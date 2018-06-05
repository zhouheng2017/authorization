/*
 * Response.java
 *
 * Created on July 19, 2007, 11:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.authorization.xacml.response;

import com.sun.xacml.Indenter;
import com.sun.xacml.Obligation;
import com.sun.xacml.ctx.*;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * The <B>Response</B> class is uses the Sun XACML API to extract the information
 * stored in the Response object.
 * @author Hemant Goyal
 */
public class Response {
    /**
     * The Response Object returned from the PDP
     */
    ResponseCtx response;
    /**
     * The Set containing all the Results extracted from the Response Object
     */
    Set Results;
    /**
     * An array containing the Results. Made from the Results Set
     */
    Result[] ResultsArr;
    /**
     * The String representation of the XML Response that is dispalyed in the GUI.
     */
    private String xmlResponse = new String();
    
    /**
     * The Number of Results returned in the Response Object.
     */
    private int NumResults;
    
    /**
     * A String Array of the Decision results returned in the Response.
     */
    private String[] Decision;
    /**
     * A String Array of the Status Details returned in the Response.
     */
    private String[] StatusDetails;
    /**
     * A String Array of the Status Message returned in the Response.
     */
    private String[] StatusMessage;
    /**
     * A String Array of the Status Code returned in the Response. Only the Major Code
     * is retrieved.
     */
    private String[] StatusCode;
    /**
     * A String Array of the Resources to which access was requested.
     */
    private String[] Resource;
    
    /**
     * A String Array of the Obligation IDs returned in the Response.
     */
    private String[] ObligationURI;
    /**
     * A String Array of the FullFillOn Parameter for each Obligation returned in the Response.
     */
    private String[] FullFillOn;
    
    /**
     * An Array which contains the AttributeAssignments for the Obligations
     */
    private Attribute[] AttributeAssignment;
    private String[] AttributeAssignmentID;
    private String[] AttributeAssignmentIssuer;
    private String[] AttributeAssignmentIssueInstant;
    private String[] AttributeAssignmentValue;
    private String[] AttributeAssignmentType;
    
    
    /** Creates a new instance of Response */
    public Response(ResponseCtx resp) {
        response = resp;
        Results = response.getResults();
        
        setNumResults();
        getResponseFromStream();
        setValues();
        
    }
    
    
    private void setNumResults(){
        NumResults = Results.size();
    }
    public void SetxmlResponse(String resp){
        this.xmlResponse = resp;
    }
    
    public void setValues(){
        
        ResultsArr = new Result[NumResults];
        StatusDetails = new String[NumResults];
        StatusMessage = new String[NumResults];
        StatusCode = new String[NumResults];
        Decision = new String[NumResults];
        Resource = new String[NumResults];
        
        ArrayList ObligationURIList = new ArrayList();
        ArrayList FullFillOnList = new ArrayList();
        ArrayList AttributeAssignmentList = new ArrayList();
        
        ResultsArr = (Result[]) Results.toArray(new Result[0]);
        
        int decision_result, indexer = 0;
        
        //Done in one function so that For Loop is not run multiple times!
        for(int i =0 ;i<NumResults; i++){
            Status temp_status = ResultsArr[i].getStatus();
            StatusDetail temp_statusDetails = temp_status.getDetail();
            
            //Get all the status info
            if(temp_statusDetails!=null)
                StatusDetails[indexer] = temp_statusDetails.getEncoded();
            
            StatusMessage[indexer] =temp_status.getMessage();
            StatusCode[indexer] = (String) temp_status.getCode().get(0);
            //We are only getting the major code
            
            //Then get the Decision and Resource Info
            decision_result = ResultsArr[i].getDecision();
            Decision[indexer] = (ResultsArr[i].DECISIONS[decision_result]);
            Resource[indexer] = ResultsArr[i].getResource();
            
            //Now get the Obligations
            Set temp_obligations = ResultsArr[i].getObligations();
            Obligation[] obligations = (Obligation[]) temp_obligations.toArray(new Obligation[0]);
            int fullFillOn_result;
            for(int j= 0; j< obligations.length; j++){
                ObligationURIList.add(obligations[j].getId().toString());
                fullFillOn_result = obligations[j].getFulfillOn();
                FullFillOnList.add(Result.DECISIONS[fullFillOn_result]);
                AttributeAssignmentList.add(obligations[j].getAssignments());
            }
            ObligationURI = (String[]) ObligationURIList.toArray(new String[0]);
            FullFillOn = (String[]) FullFillOnList.toArray(new String[0]);
        }
        
        //Finally move through the AttributeAssignmentList to create AttributeAssignment
        Vector<Attribute> Attributes = new Vector();
        for(int a= 0 ; a<AttributeAssignmentList.size(); a++){
            List temp_attribute = (List) AttributeAssignmentList.get(a);
            Attributes.addAll(temp_attribute);
        }
        AttributeAssignmentID = new String[Attributes.size()];
        AttributeAssignmentIssuer = new String[Attributes.size()];
        AttributeAssignmentIssueInstant = new String[Attributes.size()];
        AttributeAssignmentValue = new String[Attributes.size()];
        AttributeAssignmentType = new String[Attributes.size()];
        
        for(int i= 0 ; i<Attributes.size(); i++){
            if(Attributes.get(i).getId() != null)
                AttributeAssignmentID[i] = Attributes.get(i).getId().toString();
            if(Attributes.get(i).getIssuer() != null)
                AttributeAssignmentIssuer[i] = Attributes.get(i).getIssuer();
            if(Attributes.get(i).getIssueInstant() != null)
                AttributeAssignmentIssueInstant[i] = Attributes.get(i).getIssueInstant().toString();
            if(Attributes.get(i).getValue() != null)
                AttributeAssignmentValue[i] = Attributes.get(i).getValue().toString();
            if(Attributes.get(i).getType() != null)
                AttributeAssignmentType[i] = Attributes.get(i).getType().toString();
        }
        
    }
    public void getResponseFromStream(){
        ByteArrayOutputStream sbos = new ByteArrayOutputStream();
        response.encode(sbos,new Indenter());
        String resp = sbos.toString();
        SetxmlResponse(resp);
    }
    public String getResponse(){
        return this.xmlResponse;
    }
    
    public String[] getObligationURI(){
        return this.ObligationURI;
    }
    
    public String[] getFullFillOn(){
        return this.FullFillOn;
    }
    
    public String[] getAttributeAssignmentID(){
        return this.AttributeAssignmentID;
    }
    
    public String[] getAttributeAssignmentType(){
        return this.AttributeAssignmentType;
    }
    
    public String[] getAttributeAssignmentValue(){
        return this.AttributeAssignmentValue;
    }
    
    public String[] getAttributeAssignmentIssuer(){
        return this.AttributeAssignmentIssuer;
    }
    
    public String[] getAttributeAssignmentIssueInstant(){
        return this.AttributeAssignmentIssueInstant;
    }
    
    
    
    
    public String[] getResources(){
        return this.Resource;
    }
    
    public String[] getDecision(){
        return this.Decision;
    }
    
    public String[] getStatusDetails(){
        return this.StatusDetails;
    }
    
    public String[] getStatusMessage(){
        return this.StatusMessage;
    }
    
    public String[] getStatusCode(){
        return this.StatusCode;
    }
}
