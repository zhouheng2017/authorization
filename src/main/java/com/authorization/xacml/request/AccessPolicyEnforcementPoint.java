/*
 * Created on Sep 14, 2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package com.authorization.xacml.request;

import com.authorization.dto.AttributeValueDTO;
import com.sun.xacml.EvaluationCtx;
import com.sun.xacml.Indenter;
import com.sun.xacml.attr.AnyURIAttribute;
import com.sun.xacml.attr.RFC822NameAttribute;
import com.sun.xacml.attr.StringAttribute;
import com.sun.xacml.ctx.Attribute;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.Subject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * <p>
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class AccessPolicyEnforcementPoint {

    public static Set setupSubjects(String email, String role) throws URISyntaxException {
        HashSet attributes = new HashSet();

        // setup the id and value for the requesting subject
        URI subjectId = new URI("urn:oasis:names:tc:xacml:1.0:subject:subject-id");
        RFC822NameAttribute value = new RFC822NameAttribute(email);

        // create the subject section with two attributes, the first with
        // the subject's identity...
        attributes.add(new Attribute(subjectId, null, null, value));
        // ...and the second with the subject's group membership

        URI groupId = new URI("role");
        StringAttribute stringAttribValue = new StringAttribute(role);

        attributes.add(new Attribute(groupId, null, null, stringAttribValue));

        // bundle the attributes in a Subject with the default category
        HashSet subjects = new HashSet();
        subjects.add(new Subject(attributes));

        return subjects;
    }

    public static Set setupResource(String resourceValue) throws URISyntaxException {
        HashSet resource = new HashSet();

        // the resource being requested
        AnyURIAttribute value =
                new AnyURIAttribute(new URI(resourceValue));

        // create the resource using a standard, required identifier for
        // the resource being requested
        resource.add(
                new Attribute(
                        new URI(EvaluationCtx.RESOURCE_ID),
                        null,
                        null,
                        value));

        return resource;
    }

    public static Set setupAction(String actionValue) throws URISyntaxException {
        HashSet action = new HashSet();

        // this is a standard URI that can optionally be used to specify
        // the action being requested
        URI actionId = new URI("urn:oasis:names:tc:xacml:1.0:action:action-id");

        // create the action
        action.add(
                new Attribute(actionId, null, null, new StringAttribute(actionValue)));

        return action;
    }

    /**
     * Command-line interface that creates a new Request by invoking the
     * static methods in this class. The Request has no Environment section.
     */
    public static void main(String[] args) throws Exception {
        // create the new Request...note that the Environment must be specified
        // using a valid Set, even if that Set is empty
        RequestCtx request =
                new RequestCtx(
                        setupSubjects("zhouheng@cnpc.com.cn", "employee"),
                        setupResource("jdbc:mysql://localhost:3306/userInfo"),
                        setupAction("read:1-3"),
                        new HashSet());

        String path = "E:\\maven\\workspace\\java2\\xacml\\src\\main\\java\\org\\eklavya\\accesscontrol\\/requestUserInfo.xml";
        OutputStream outputStream = new FileOutputStream(new File(path));
        // encode the Request and print it to standard out
        request.encode(System.out, new Indenter());
        request.encode(outputStream, new Indenter());
    }

    public static RequestCtx getRequest(AttributeValueDTO attributeValueDTO) throws URISyntaxException {
/*        RequestCtx request =
                new RequestCtx(
                        setupSubjects("zhouheng@cnpc.com.cn", "employee"),
                        setupResource("jdbc:mysql://localhost:3306/userInfo"),
                        setupAction("read:1-3"),
                        new HashSet());*/
        RequestCtx request =
                new RequestCtx(
                        setupSubjects(attributeValueDTO.getEmail(), attributeValueDTO.getRole()),
                        setupResource(attributeValueDTO.getResourceValue()),
                        setupAction(attributeValueDTO.getActionValue()),
                        new HashSet());

        request.encode(System.out, new Indenter());

        return request;
    }

}
