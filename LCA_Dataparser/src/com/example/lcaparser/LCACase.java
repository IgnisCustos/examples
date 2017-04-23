package com.example.lcaparser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.annotation.LCA;
import com.example.annotation.LCARegex;
import com.example.annotation.LCASetter;

/**
 * Three Values are chained thogether NAME of VARIABLE annotated with LAC.class (position,type)
 * 
 * NAME of REGEX-Variable annotated wit LCARegex.class
 * 
 * NAME of SETTER for VARIABLE annotated wit LCASetter.class
 * 
 * @author Ignis
 *
 */
public class LCACase
{

    // Fields
    @LCA(pos = 1, type = "VARCHAR(100)")
    private String caseNo;
    @LCA(pos = 2, type = "VARCHAR(100)")
    private String caseStatus;
    @LCA(pos = 3, type = "DATE")
    private String caseSubmitted;
    @LCA(pos = 4, type = "DATE")
    private String decisionDate;
    @LCA(pos = 5, type = "VARCHAR(100)")
    private String visaClass;
    @LCA(pos = 6, type = "DATE")
    private String employmentStartDate;
    @LCA(pos = 7, type = "DATE")
    private String employmentEndDate;
    @LCA(pos = 8, type = "VARCHAR(100)")
    private String employerName;
    @LCA(pos = 9, type = "VARCHAR(100)")
    private String employerAddress;
    @LCA(pos = 10, type = "VARCHAR(100)")
    private String employerCity;
    @LCA(pos = 11, type = "VARCHAR(100)")
    private String employerState;
    @LCA(pos = 12, type = "VARCHAR(100)")
    private String employerPostalCode;
    @LCA(pos = 13, type = "VARCHAR(100)")
    private String jobTitle;
    @LCA(pos = 14, type = "VARCHAR(100)")
    private String socCode;
    @LCA(pos = 15, type = "VARCHAR(100)")
    private String socName;
    @LCA(pos = 16, type = "VARCHAR(100)")
    private String totalWorkers;
    @LCA(pos = 17, type = "VARCHAR(100)")
    private String fullTimePosition;
    @LCA(pos = 18, type = "NUMERIC")
    private String prevailingWage;
    @LCA(pos = 19, type = "VARCHAR(100)")
    private String prevailingWageUnitOfPay;
    @LCA(pos = 20, type = "VARCHAR(100)")
    private String prevailingWageSource;
    @LCA(pos = 21, type = "VARCHAR(100)")
    private String wageRateOfPay;
    @LCA(pos = 22, type = "VARCHAR(100)")
    private String wageUnitOfPay;
    @LCA(pos = 23, type = "VARCHAR(100)")
    private String worksiteCity;
    @LCA(pos = 24, type = "VARCHAR(100)")
    private String worksiteCounty;
    @LCA(pos = 25, type = "VARCHAR(100)")
    private String worksiteState;
    @LCA(pos = 26, type = "VARCHAR(100)")
    private String worksitePostalCode;
    @LCA(pos = 27, type = "VARCHAR(100)")
    private String NAIC;

    // Regex for fields
    @LCARegex
    private static String regexCaseNo = "(CASE)_(NO|NUMBER)";
    @LCARegex
    private static String regexCaseStatus = "(CASE)?_?(STATUS)";
    @LCARegex
    private static String regexCaseSubmitted = "(CASE)?_?(SUBMIT)";
    @LCARegex
    private static String regexDecisionDate = "(DECISION)_?(DATE)";
    @LCARegex
    private static String regexVisaClass = "(VISA)_?(CLASS)";
    @LCARegex
    private static String regexEmploymentStartDate = "\\w+(START)_(DATE)";
    @LCARegex
    private static String regexEmploymentEndDate = "\\w+(END)_(DATE)";
    @LCARegex
    private static String regexEmployerName = "(EMPLOYER)_(NAME)";
    @LCARegex
    private static String regexEmployerAddress = "\\w+(EMPLOYER)?_?(ADDRESS)(?!2)";
    @LCARegex
    private static String regexEmployerCity = "(EMPLOYER)_?(CITY)";
    @LCARegex
    private static String regexEmployerState = "(EMPLOYER)_?(STATE)";
    @LCARegex
    private static String regexEmployerPostalCode = "(EMPLOYER)_?(POSTAL)";
    @LCARegex
    private static String regexJobTitle = "(JOB)_?(TITLE)";
    @LCARegex
    private static String regexSocCode = "(SOC)_?(CODE)";
    @LCARegex
    private static String regexSocName = "(SOC)_?(NAME)";
    @LCARegex
    private static String regexTotalWorkers = "(TOTAL)( |_)(WORKERS)";
    @LCARegex
    private static String regexFullTimePosition = "(FULL)_?(TIME)";
    @LCARegex
    private String regexPrevailingWage = "(PREVAILING_WAGE|PW_1)";
    @LCARegex
    private String regexPrevailingWageUnitOfPay = "(PW)_(UNIT)(?!_2)";
    @LCARegex
    private String regexPrevailingWageSource = "(PW).*(SOURCE)(?!_2)";
    @LCARegex
    private String regexWageRateOfPay = "(WAGE).*(RATE).*(PAY)";
    @LCARegex
    private String regexWageUnitOfPay = "(WAGE).*(UNIT).*(PAY)";
    @LCARegex
    private static String regexWorksiteCity = "(WORK)(LOC1|SITE)_?(CITY)";
    @LCARegex
    private static String regexWorksiteCounty = "(WORK)(LOC1|SITE)_?(COUNTY)";
    @LCARegex
    private static String regexWorksiteState = "(WORK)(LOC1|SITE)_?(STATE)";
    @LCARegex
    private static String regexWorksitePostalCode = "(WORK)(LOC1|SITE)_?(POSTAL)";
    @LCARegex
    private static String regexNAIC = "(NAIC)";

    private Map<String, String> declarationMap;

    public LCACase()
    {
    }

    public LCACase(String forInit)
    {
	this.declarationMap = setDeclarationMap();
	System.out.println("");
	System.out.println("------------------- declarationMap (Entrys: " + declarationMap.size() + ") ---------------------");
	for (Map.Entry<String, String> entry : declarationMap.entrySet())
	{
	    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}
	System.out.println("----------------------------------------");

    }

    private Map<String, String> setDeclarationMap()
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

    @LCASetter
    public Map<String, String> getDeclarationmap()
    {
	return declarationMap;
    }

    @LCASetter
    public void setCaseNo(String caseNo)
    {
	this.caseNo = caseNo;
    }

    @LCASetter
    public void setCaseStatus(String caseStatus)
    {
	this.caseStatus = caseStatus;
    }

    @LCASetter
    public void setCaseSubmitted(String caseSubmitted)
    {
	this.caseSubmitted = caseSubmitted;
    }

    @LCASetter
    public void setDecisionDate(String decisionDate)
    {
	this.decisionDate = decisionDate;
    }

    @LCASetter
    public void setVisaClass(String visaClass)
    {
	this.visaClass = visaClass;
    }

    @LCASetter
    public void setEmploymentStartDate(String employmentStartDate)
    {
	this.employmentStartDate = employmentStartDate;
    }

    @LCASetter
    public void setEmploymentEndDate(String employmentEndDate)
    {
	this.employmentEndDate = employmentEndDate;
    }

    @LCASetter
    public void setEmployerName(String employerName)
    {
	this.employerName = employerName;
    }

    @LCASetter
    public void setEmployerAddress(String employerAddress)
    {
	this.employerAddress = employerAddress;
    }

    @LCASetter
    public void setEmployerCity(String employerCity)
    {
	this.employerCity = employerCity;
    }

    @LCASetter
    public void setEmployerState(String employerState)
    {
	this.employerState = employerState;
    }

    @LCASetter
    public void setEmployerPostalCode(String employerPostalCode)
    {
	this.employerPostalCode = employerPostalCode;
    }

    @LCASetter
    public void setJobTitle(String jobTitle)
    {
	this.jobTitle = jobTitle;
    }

    @LCASetter
    public void setSocCode(String socCode)
    {
	this.socCode = socCode;
    }

    @LCASetter
    public void setSocName(String socName)
    {
	this.socName = socName;
    }

    @LCASetter
    public void setTotalWorkers(String totalWorkers)
    {
	this.totalWorkers = totalWorkers;
    }

    @LCASetter
    public void setFullTimePosition(String fullTimePosition)
    {
	this.fullTimePosition = fullTimePosition;
    }

    @LCASetter
    public void setPrevailingWage(String prevailingWage)
    {
	this.prevailingWage = prevailingWage;
    }

    @LCASetter
    public void setPrevailingWageUnitOfPay(String prevailingWageUnitOfPay)
    {
	this.prevailingWageUnitOfPay = prevailingWageUnitOfPay;
    }

    @LCASetter
    public void setPrevailingWageSource(String prevailingWageSource)
    {
	this.prevailingWageSource = prevailingWageSource;
    }

    @LCASetter
    public void setWageRateOfPay(String wageRateOfPay)
    {
	this.wageRateOfPay = wageRateOfPay;
    }

    @LCASetter
    public void setWageUnitOfPay(String wageUnitOfPay)
    {
	this.wageUnitOfPay = wageUnitOfPay;
    }

    @LCASetter
    public void setWorksiteCity(String worksiteCity)
    {
	this.worksiteCity = worksiteCity;
    }

    @LCASetter
    public void setWorksiteCounty(String worksiteCounty)
    {
	this.worksiteCounty = worksiteCounty;
    }

    @LCASetter
    public void setWorksiteState(String worksiteState)
    {
	this.worksiteState = worksiteState;
    }

    @LCASetter
    public void setWorksitePostalCode(String worksitePostalCode)
    {
	this.worksitePostalCode = worksitePostalCode;
    }

    @LCASetter
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
	return buildINSERT();
    }

    /**
     * Build INSERT INTO Query entirely from annotation
     * 
     * @return
     */
    private String buildINSERT()
    {
	Map<Integer, Field> databaseFields = new LinkedHashMap<>();
	List<String> createTableQuery = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	sb.append("INSERT INTO lca VALUES(");
	createTableQuery.add("INSERT INTO lca VALUES(");

	Field[] fields = LCACase.class.getDeclaredFields();
	for (Field field : fields)
	{
	    if (Modifier.isPrivate(field.getModifiers()) && field.isAnnotationPresent(LCA.class))
	    {
		databaseFields.put(field.getAnnotation(LCA.class).pos(), field);
	    }
	}

	for (int i = 1; i <= databaseFields.size(); i++)
	{
	    try
	    {
		Field field = databaseFields.get(i);
		switch (field.getAnnotation(LCA.class).type())
		{
		    case "VARCHAR(100)":
			sb.append(inputValidationStr((String) field.get(this)));
			break;
		    case "DATE":
			sb.append(inputValidationDate((String) field.get(this)));
			break;
		    case "NUMERIC":
			sb.append(inputValidationNumeric((String) field.get(this)));
			break;
		    default:
			throw new IllegalArgumentException("Your DataType isn't supported yet");

		}
		sb.append((i < databaseFields.size() ? "," : ""));
	    }
	    catch (IllegalArgumentException | IllegalAccessException e)
	    {
		e.printStackTrace();
	    }

	}
	sb.append(");");
	return sb.toString();
    }

    public static List<String> createTABLE()
    {
	List<String> createTableQuery = new ArrayList<>();
	createTableQuery.add("DROP TABLE IF EXISTS lca;");
	createTableQuery.add("CREATE TABLE lca(");

	Map<Integer, Field> databaseFields = new LinkedHashMap<>();

	Field[] fields = LCACase.class.getDeclaredFields();
	for (Field field : fields)
	{
	    if (Modifier.isPrivate(field.getModifiers()) && field.isAnnotationPresent(LCA.class))
	    {
		databaseFields.put(field.getAnnotation(LCA.class).pos(), field);
	    }
	}

	for (int i = 1; i <= databaseFields.size(); i++)
	{
	    Field field = databaseFields.get(i);
	    createTableQuery.add(field.getName() + " " + field.getAnnotation(LCA.class).type() + (i < databaseFields.size() ? "," : ""));
	}
	createTableQuery.add(");");

	return createTableQuery;
    }

    private String inputValidationStr(String inserValue)
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

    private String inputValidationDate(String dateStr)
    {
	SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateParser(dateStr);

	if (date == null)
	    return "null";
	dateStr = sdfOutput.format(date);
	return "'" + dateStr + "'";

    }

    private String inputValidationNumeric(String floatStr)
    {
	if (floatStr != null)
	{
	    try
	    {
		Double.parseDouble(floatStr);
	    }
	    catch (NumberFormatException e)
	    {
		floatStr = "null";
	    }

	}
	else
	{
	    floatStr = "null";
	}
	return floatStr;
    }

    /**
     * try to parse a given string that is properly a date into a Date
     * 
     * @param candidate
     * @return
     */
    private Date dateParser(String candidate)
    {
	if (candidate == null)
	    return null;
	List<SimpleDateFormat> knownPatterns = new ArrayList<SimpleDateFormat>();
	knownPatterns.add(new SimpleDateFormat("yyyy-MM-dd"));
	knownPatterns.add(new SimpleDateFormat("dd/MM/yyyy"));
	knownPatterns.add(new SimpleDateFormat("dd.MM.yyyy"));

	for (SimpleDateFormat pattern : knownPatterns)
	{
	    try
	    {
		return new Date(pattern.parse(candidate).getTime());
	    }
	    catch (ParseException pe)
	    {
		// dateParser(candidate);
	    }
	}
	return null;
    }
}
