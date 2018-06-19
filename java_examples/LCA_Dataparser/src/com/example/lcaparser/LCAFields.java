package com.example.lcaparser;

import com.example.annotation.LCA;
import com.example.annotation.LCARegex;
import com.example.annotation.LCASetter;

/**
 * Declare two variables and one method to process them correctly and dynamically by LCAService.class
 * 
 * annotated var fieldname annotated var regexFieldname annotated meth setFieldname
 * 
 * 
 * @author Ignis
 *
 */
public abstract class LCAFields
{

    // ----------------------------------------
    /*
     * Should match CASE_NO(2008); LCA_CASE_NUMBER(2011); LCA_CASE_NUMBER(2014); CASE_NUMBER(2015)
     */
    @LCA(pos = 1, type = "VARCHAR(100)")
    private String caseNo;
    @LCARegex
    private static String regexCaseNo = "(CASE)_(NO|NUMBER)";

    @LCASetter
    public void setCaseNo(String caseNo)
    {
	this.caseNo = caseNo;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); STATUS(2011,2014); CASE_STATUS(2015)
     */
    @LCA(pos = 2, type = "VARCHAR(100)")
    private String caseStatus;
    @LCARegex
    private static String regexCaseStatus = "(CASE)?_?(STATUS)";

    @LCASetter
    public void setCaseStatus(String caseStatus)
    {
	this.caseStatus = caseStatus;
    }

    // ----------------------------------------
    /*
     * Should match SUBMITTED_DATE(2008); LCA_CASE_SUBMIT(2011,2014); CASE_SUBMITTED(2015)
     */
    @LCA(pos = 3, type = "DATE")
    private String caseSubmitted;
    @LCARegex
    private static String regexCaseSubmitted = "(CASE)?_?(SUBMIT)";

    @LCASetter
    public void setCaseSubmitted(String caseSubmitted)
    {
	this.caseSubmitted = caseSubmitted;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); DECISION_DATE(2011,2014); DECISION_DATE(2015)
     */
    @LCA(pos = 4, type = "DATE")
    private String decisionDate;
    @LCARegex
    private static String regexDecisionDate = "(DECISION)_?(DATE)";

    @LCASetter
    public void setDecisionDate(String decisionDate)
    {
	this.decisionDate = decisionDate;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); VISA_CLASS(2011,2014); VISA_CLASS(2015)
     */
    @LCA(pos = 5, type = "VARCHAR(100)")
    private String visaClass;
    @LCARegex
    private static String regexVisaClass = "(VISA)_?(CLASS)";

    @LCASetter
    public void setVisaClass(String visaClass)
    {
	this.visaClass = visaClass;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); LCA_CASE_EMPLOYMENT_START_DATE(2011,2014); EMPLOYMENT_START_DATE(2015)
     */
    @LCA(pos = 6, type = "DATE")
    private String employmentStartDate;
    @LCARegex
    private static String regexEmploymentStartDate = "(EMPLOY.*START|BEGIN)_(DATE)";

    @LCASetter
    public void setEmploymentStartDate(String employmentStartDate)
    {
	this.employmentStartDate = employmentStartDate;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); LCA_CASE_EMPLOYMENT_END_DATE(2011,2014); EMPLOYMENT_END_DATE(2015)
     */
    @LCA(pos = 7, type = "DATE")
    private String employmentEndDate;
    @LCARegex
    private static String regexEmploymentEndDate = "(END)_(DATE)";

    @LCASetter
    public void setEmploymentEndDate(String employmentEndDate)
    {
	this.employmentEndDate = employmentEndDate;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 8, type = "VARCHAR(100)")
    private String employerName;
    @LCARegex
    private static String regexEmployerName = "(\bNAME\b|EMPLOYER_NAME)";

    @LCASetter
    public void setEmployerName(String employerName)
    {
	this.employerName = employerName;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 9, type = "VARCHAR(100)")
    private String employerAddress;
    @LCARegex
    private static String regexEmployerAddress = "(\b.*ADDRESS(|1)\b)";

    @LCASetter
    public void setEmployerAddress(String employerAddress)
    {
	this.employerAddress = employerAddress;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 10, type = "VARCHAR(100)")
    private String employerCity;
    @LCARegex
    private static String regexEmployerCity = "(EMPLOYER_CITY|\bCITY\b)";

    @LCASetter
    public void setEmployerCity(String employerCity)
    {
	this.employerCity = employerCity;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 11, type = "VARCHAR(100)")
    private String employerState;
    @LCARegex
    private static String regexEmployerState = "(EMPLOYER_STATE|\bSTATE\b)";

    @LCASetter
    public void setEmployerState(String employerState)
    {
	this.employerState = employerState;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 12, type = "VARCHAR(100)")
    private String employerPostalCode;
    @LCARegex
    private static String regexEmployerPostalCode = "(EMPLOYER_POSTAL_CODE|\bPOSTAL_CODE\b)";

    @LCASetter
    public void setEmployerPostalCode(String employerPostalCode)
    {
	this.employerPostalCode = employerPostalCode;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 13, type = "VARCHAR(100)")
    private String jobTitle;
    @LCARegex
    private static String regexJobTitle = "(JOB)_?(TITLE)";

    @LCASetter
    public void setJobTitle(String jobTitle)
    {
	this.jobTitle = jobTitle;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 14, type = "VARCHAR(100)")
    private String socCode;
    @LCARegex
    private static String regexSocCode = "(JOB.CODE|SOC.CODE)";

    @LCASetter
    public void setSocCode(String socCode)
    {
	this.socCode = socCode;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 15, type = "VARCHAR(100)")
    private String socName;
    @LCARegex
    private static String regexSocName = "(OCCUPATIONAL|SOC.NAME)";

    @LCASetter
    public void setSocName(String socName)
    {
	this.socName = socName;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 16, type = "VARCHAR(100)")
    private String totalWorkers;
    @LCARegex
    private static String regexTotalWorkers = "(IMMIGRANTS|WORKERS)";

    @LCASetter
    public void setTotalWorkers(String totalWorkers)
    {
	this.totalWorkers = totalWorkers;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 17, type = "VARCHAR(100)")
    private String fullTimePosition;
    @LCARegex
    private static String regexFullTimePosition = "((FULL|PART).TIME)";

    @LCASetter
    public void setFullTimePosition(String fullTimePosition)
    {
	this.fullTimePosition = fullTimePosition;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 18, type = "NUMERIC")
    private String prevailingWage;
    @LCARegex
    private String regexPrevailingWage = "((PREVAILING_WAGE(_1)*)(?!_2)|PW_1)";

    @LCASetter
    public void setPrevailingWage(String prevailingWage)
    {
	this.prevailingWage = prevailingWage;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 19, type = "VARCHAR(100)")
    private String prevailingWageUnitOfPay;
    @LCARegex
    private String regexPrevailingWageUnitOfPay = "(PW_UNIT|\bWAGE_SOURCE_1\b)(?!_2)";

    @LCASetter
    public void setPrevailingWageUnitOfPay(String prevailingWageUnitOfPay)
    {
	this.prevailingWageUnitOfPay = prevailingWageUnitOfPay;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 20, type = "VARCHAR(100)")
    private String prevailingWageSource;
    @LCARegex
    private String regexPrevailingWageSource = "(PW).*(SOURCE)(?!_2)";

    @LCASetter
    public void setPrevailingWageSource(String prevailingWageSource)
    {
	this.prevailingWageSource = prevailingWageSource;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 21, type = "VARCHAR(100)")
    private String wageRateOfPay;
    @LCARegex
    private String regexWageRateOfPay = "(WAGE).*(RATE).*(PAY)|(RATE_PER_1)";

    @LCASetter
    public void setWageRateOfPay(String wageRateOfPay)
    {
	this.wageRateOfPay = wageRateOfPay;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 22, type = "VARCHAR(100)")
    private String wageUnitOfPay;
    @LCARegex
    private String regexWageUnitOfPay = "(WAGE).*(UNIT).*(PAY)";

    @LCASetter
    public void setWageUnitOfPay(String wageUnitOfPay)
    {
	this.wageUnitOfPay = wageUnitOfPay;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 23, type = "VARCHAR(100)")
    private String worksiteCity;
    @LCARegex
    private static String regexWorksiteCity = "(WORK)(LOC1|SITE)_?(CITY)";

    @LCASetter
    public void setWorksiteCity(String worksiteCity)
    {
	this.worksiteCity = worksiteCity;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 24, type = "VARCHAR(100)")
    private String worksiteCounty;
    @LCARegex
    private static String regexWorksiteCounty = "(WORK)(LOC1|SITE)_?(COUNTY)";

    @LCASetter
    public void setWorksiteCounty(String worksiteCounty)
    {
	this.worksiteCounty = worksiteCounty;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 25, type = "VARCHAR(100)")
    private String worksiteState;
    @LCARegex
    private static String regexWorksiteState = "(WORK)(LOC1|SITE)_?(STATE)";

    @LCASetter
    public void setWorksiteState(String worksiteState)
    {
	this.worksiteState = worksiteState;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 26, type = "VARCHAR(100)")
    private String worksitePostalCode;
    @LCARegex
    private static String regexWorksitePostalCode = "(WORK)(LOC1|SITE)_?(POSTAL)";

    @LCASetter
    public void setWorksitePostalCode(String worksitePostalCode)
    {
	this.worksitePostalCode = worksitePostalCode;
    }

    // ----------------------------------------
    /*
     * Should match TODO(2008); TODO(2011,2014); TODO(2015)
     */
    @LCA(pos = 27, type = "VARCHAR(100)")
    private String NAIC;
    @LCARegex
    private static String regexNAIC = "(NAIC)";

    @LCASetter
    public void setNAIC(String naic)
    {
	this.NAIC = naic;
    }

}
