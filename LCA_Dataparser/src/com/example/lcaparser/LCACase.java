package com.example.lcaparser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class LCACase
{

    // Fields
    @LCA(pos = 1)
    private String caseNo;
    @LCA(pos = 2)
    private String caseStatus;
    @LCA(pos = 3)
    private String caseSubmitted;
    @LCA(pos = 4)
    private String decisionDate;
    @LCA(pos = 5)
    private String visaClass;
    @LCA(pos = 6)
    private String employmentStartDate;
    @LCA(pos = 7)
    private String employmentEndDate;
    @LCA(pos = 8)
    private String employerName;
    @LCA(pos = 9)
    private String employerAddress;
    @LCA(pos = 10)
    private String employerCity;
    @LCA(pos = 11)
    private String employerState;
    @LCA(pos = 12)
    private String employerPostalCode;
    @LCA(pos = 13)
    private String jobTitle;
    @LCA(pos = 14)
    private String socCode;
    @LCA(pos = 15)
    private String socName;
    @LCA(pos = 16)
    private String totalWorkers;
    @LCA(pos = 17)
    private String fullTimePosition;
    @LCA(pos = 18)
    private String worksiteLocation;
    @LCA(pos = 19)
    private String worksiteState;
    @LCA(pos = 20)
    private String NAIC;

    // Regex for fields
    private static String regexCaseNo = "(CASE)_(NO|NUMBER)";
    private static String regexCaseStatus = "(CASE)?_?(STATUS)";
    private static String regexCaseSubmitted = "(CASE)?_?(SUBMIT)";
    private static String regexDecisionDate = "(DECISION)_?(DATE)";
    private static String regexVisaClass = "(VISA)_?(CLASS)";
    private static String regexEmploymentStartDate = "\\w+(START)_(DATE)";
    private static String regexEmploymentEndDate = "\\w+(END)_(DATE)";
    private static String regexEmployerName = "(EMPLOYER)_(NAME)";
    private static String regexEmployerAddress = "\\w+(EMPLOYER)?_?(ADDRESS)(?!2)";
    private static String regexEmployerCity = "(EMPLOYER)_?(CITY)";
    private static String regexEmployerState = "(EMPLOYER)_?(STATE)";
    private static String regexEmployerPostalCode = "(EMPLOYER)_?(POSTAL)";
    private static String regexJobTitle = "(JOB)_?(TITLE)";
    private static String regexSocCode = "(SOC)_?(CODE)";
    private static String regexSocName = "(SOC)_?(NAME)";
    private static String regexTotalWorkers = "(TOTAL)( |_)(WORKERS)";
    private static String regexFullTimePosition = "(FULL)_?(TIME)";
    private static String regexWorksiteLocation = "(WORK)(LOC1|SITE)_?(CITY)";
    private static String regexWorksiteState = "(WORK)(LOC1|SITE)_?(STATE)";
    private static String regexNAIC = "(NAIC)";

    private Map<String, String> declarationMap;

    public LCACase()
    {
    }

    public LCACase(String forInit)
    {
	this.declarationMap = setDeclarationmap();
	System.out.println("------------------- declarationMap (Entrys: " + declarationMap.size() + ") ---------------------");
	for (Map.Entry<String, String> entry : declarationMap.entrySet())
	{
	    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}
	System.out.println("----------------------------------------");

    }

    private Map<String, String> setDeclarationmap()
    {
	Map<String, String> declarationMap = new HashMap<String, String>();
	try
	{
	    Field[] fields = LCACase.class.getDeclaredFields();
	    for (Field field : fields)
	    {
		if (Modifier.isPrivate(field.getModifiers()))
		{
		    String value = (String) field.get(this);
		    if (field.getName().contains("regex"))
		    {
			declarationMap.put(field.getName(), value);
		    }
		}
	    }
	}
	catch (SecurityException | IllegalArgumentException | IllegalAccessException e)
	{
	    e.printStackTrace();
	}
	return declarationMap;
    }

    public Map<String, String> getDeclarationmap()
    {
	return declarationMap;
    }

    public void setCaseNo(String caseNo)
    {
	this.caseNo = caseNo;
    }

    public void setCaseStatus(String caseStatus)
    {
	this.caseStatus = caseStatus;
    }

    public void setCaseSubmitted(String caseSubmitted)
    {
	this.caseSubmitted = caseSubmitted;
    }

    public void setDecisionDate(String decisionDate)
    {
	this.decisionDate = decisionDate;
    }

    public void setVisaClass(String visaClass)
    {
	this.visaClass = visaClass;
    }

    public void setEmploymentStartDate(String employmentStartDate)
    {
	this.employmentStartDate = employmentStartDate;
    }

    public void setEmploymentEndDate(String employmentEndDate)
    {
	this.employmentEndDate = employmentEndDate;
    }

    public void setEmployerName(String employerName)
    {
	this.employerName = employerName;
    }

    public void setEmployerAddress(String employerAddress)
    {
	this.employerAddress = employerAddress;
    }

    public void setEmployerCity(String employerCity)
    {
	this.employerCity = employerCity;
    }

    public void setEmployerState(String employerState)
    {
	this.employerState = employerState;
    }

    public void setEmployerPostalCode(String employerPostalCode)
    {
	this.employerPostalCode = employerPostalCode;
    }

    public void setJobTitle(String jobTitle)
    {
	this.jobTitle = jobTitle;
    }

    public void setSocCode(String socCode)
    {
	this.socCode = socCode;
    }

    public void setSocName(String socName)
    {
	this.socName = socName;
    }

    public void setTotalWorkers(String totalWorkers)
    {
	this.totalWorkers = totalWorkers;
    }

    public void setFullTimePosition(String fullTimePosition)
    {
	this.fullTimePosition = fullTimePosition;
    }

    public void setWorksiteLocation(String worksiteLocation)
    {
	this.worksiteLocation = worksiteLocation;
    }

    public void setWorksiteState(String worksiteState)
    {
	this.worksiteState = worksiteState;
    }

    public void setNAIC(String naic)
    {
	this.NAIC = naic;
    }

    public void setDeclarationMap(Map<String, String> declarationMap)
    {
	this.declarationMap = declarationMap;
    }

    @Override
    public String toString()
    {
	// String str = "LCACase [caseNo=" + caseNo + ", caseStatus=" + caseStatus + ", caseSubmitted=" + caseSubmitted + ", decisionDate=" + decisionDate + ", visaClass=" + visaClass + ", employmentStartDate=" + employmentStartDate
	// + ", employmentEndDate=" + employmentEndDate + ", employerName=" + employerName + ", employerAddress=" + employerAddress + ", employerCity=" + employerCity + ", employerState=" + employerState + ", employerPostalCode="
	// + employerPostalCode + ", jobTitle=" + jobTitle + ", socCode=" + socCode + ", socName=" + socName + ", totalWorkers=" + totalWorkers + ", fullTimePosition=" + fullTimePosition + ", worksiteLocation=" + worksiteLocation
	// + ", worksiteState=" + worksiteState + ", naic=" + NAIC + "]";
	return buildINSERT();
    }

    private String buildINSERT()
    {
	StringBuilder sb = new StringBuilder();
	sb.append("INSERT INTO lca VALUES(");
	sb.append(inputValidation(caseNo)).append(",");
	sb.append(inputValidation(caseStatus)).append(",");
	sb.append(inputValidation(caseSubmitted)).append(",");
	sb.append(inputValidation(decisionDate)).append(",");
	sb.append(inputValidation(visaClass)).append(",");
	sb.append(inputValidation(employmentStartDate)).append(",");
	sb.append(inputValidation(employmentEndDate)).append(",");
	sb.append(inputValidation(employerName)).append(",");
	sb.append(inputValidation(employerAddress)).append(",");
	sb.append(inputValidation(employerCity)).append(",");
	sb.append(inputValidation(employerState)).append(",");
	sb.append(inputValidation(employerPostalCode)).append(",");
	sb.append(inputValidation(jobTitle)).append(",");
	sb.append(inputValidation(socCode)).append(",");
	sb.append(inputValidation(socName)).append(",");
	sb.append(inputValidation(totalWorkers)).append(",");
	sb.append(inputValidation(fullTimePosition)).append(",");
	sb.append(inputValidation(worksiteLocation)).append(",");
	sb.append(inputValidation(worksiteState)).append(",");
	sb.append(inputValidation(NAIC)).append(");");

	return sb.toString();
    }

    public static String createTABLE()
    {
	StringBuilder sb = new StringBuilder();
	sb.append("CREATE TABLE lca(");
	sb.append("caseNo").append(" ").append("varchar(100)").append(" ").append(",");
	sb.append("caseStatus").append(" ").append("varchar(100)").append(",");
	sb.append("caseSubmitted").append(" ").append("varchar(100)").append(",");
	sb.append("decisionDate").append(" ").append("varchar(100)").append(",");
	sb.append("visaClass").append(" ").append("varchar(100)").append(",");
	sb.append("employmentStartDate").append(" ").append("varchar(100)").append(",");
	sb.append("employmentEndDate").append(" ").append("varchar(100)").append(",");
	sb.append("employerName").append(" ").append("varchar(100)").append(",");
	sb.append("employerAddress").append(" ").append("varchar(100)").append(",");
	sb.append("employerCity").append(" ").append("varchar(100)").append(",");
	sb.append("employerState").append(" ").append("varchar(100)").append(",");
	sb.append("employerPostalCode").append(" ").append("varchar(100)").append(",");
	sb.append("jobTitle").append(" ").append("varchar(100)").append(",");
	sb.append("socCode").append(" ").append("varchar(100)").append(",");
	sb.append("socName").append(" ").append("varchar(100)").append(",");
	sb.append("totalWorkers").append(" ").append("varchar(100)").append(",");
	sb.append("fullTimePosition").append(" ").append("varchar(100)").append(",");
	sb.append("worksiteLocation").append(" ").append("varchar(100)").append(",");
	sb.append("worksiteState").append(" ").append("varchar(100)").append(",");
	sb.append("NAIC");
	sb.append(");");

	return sb.toString();
    }

    private String inputValidation(String inserValue)
    {
	if (inserValue != null)
	{
	    inserValue = "'" + inserValue.replace("'", "''") + "'";
	}
	else
	{
	    inserValue = "null";
	}
	return inserValue;
    }

}
