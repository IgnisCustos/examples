package com.example.lcaparser;

import com.example.annotation.LCA;
import com.example.annotation.LCARegex;
import com.example.annotation.LCASetter;

public class LCAFields
{

    // ----------------------------------------
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
    @LCA(pos = 6, type = "DATE")
    private String employmentStartDate;
    @LCARegex
    private static String regexEmploymentStartDate = "\\w+(START)_(DATE)";

    @LCASetter
    public void setEmploymentStartDate(String employmentStartDate)
    {
	this.employmentStartDate = employmentStartDate;
    }

    // ----------------------------------------
    @LCA(pos = 7, type = "DATE")
    private String employmentEndDate;
    @LCARegex
    private static String regexEmploymentEndDate = "\\w+(END)_(DATE)";

    @LCASetter
    public void setEmploymentEndDate(String employmentEndDate)
    {
	this.employmentEndDate = employmentEndDate;
    }

    // ----------------------------------------
    @LCA(pos = 8, type = "VARCHAR(100)")
    private String employerName;
    @LCARegex
    private static String regexEmployerName = "(EMPLOYER)_(NAME)";

    @LCASetter
    public void setEmployerName(String employerName)
    {
	this.employerName = employerName;
    }

    // ----------------------------------------
    @LCA(pos = 9, type = "VARCHAR(100)")
    private String employerAddress;
    @LCARegex
    private static String regexEmployerAddress = "\\w+(EMPLOYER)?_?(ADDRESS)(?!2)";

    @LCASetter
    public void setEmployerAddress(String employerAddress)
    {
	this.employerAddress = employerAddress;
    }

    // ----------------------------------------
    @LCA(pos = 10, type = "VARCHAR(100)")
    private String employerCity;
    @LCARegex
    private static String regexEmployerCity = "(EMPLOYER)_?(CITY)";

    @LCASetter
    public void setEmployerCity(String employerCity)
    {
	this.employerCity = employerCity;
    }

    // ----------------------------------------
    @LCA(pos = 11, type = "VARCHAR(100)")
    private String employerState;
    @LCARegex
    private static String regexEmployerState = "(EMPLOYER)_?(STATE)";

    @LCASetter
    public void setEmployerState(String employerState)
    {
	this.employerState = employerState;
    }

    // ----------------------------------------
    @LCA(pos = 12, type = "VARCHAR(100)")
    private String employerPostalCode;
    @LCARegex
    private static String regexEmployerPostalCode = "(EMPLOYER)_?(POSTAL)";

    @LCASetter
    public void setEmployerPostalCode(String employerPostalCode)
    {
	this.employerPostalCode = employerPostalCode;
    }

    // ----------------------------------------
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
    @LCA(pos = 14, type = "VARCHAR(100)")
    private String socCode;
    @LCARegex
    private static String regexSocCode = "(SOC)_?(CODE)";

    @LCASetter
    public void setSocCode(String socCode)
    {
	this.socCode = socCode;
    }

    // ----------------------------------------
    @LCA(pos = 15, type = "VARCHAR(100)")
    private String socName;
    @LCARegex
    private static String regexSocName = "(SOC)_?(NAME)";

    @LCASetter
    public void setSocName(String socName)
    {
	this.socName = socName;
    }

    // ----------------------------------------
    @LCA(pos = 16, type = "VARCHAR(100)")
    private String totalWorkers;
    @LCARegex
    private static String regexTotalWorkers = "(TOTAL)( |_)(WORKERS)";

    @LCASetter
    public void setTotalWorkers(String totalWorkers)
    {
	this.totalWorkers = totalWorkers;
    }

    // ----------------------------------------
    @LCA(pos = 17, type = "VARCHAR(100)")
    private String fullTimePosition;
    @LCARegex
    private static String regexFullTimePosition = "(FULL)_?(TIME)";

    @LCASetter
    public void setFullTimePosition(String fullTimePosition)
    {
	this.fullTimePosition = fullTimePosition;
    }

    // ----------------------------------------
    @LCA(pos = 18, type = "NUMERIC")
    private String prevailingWage;
    @LCARegex
    private String regexPrevailingWage = "(PREVAILING.*|PW.*)_(WAGE.1|WAGE\b|.*UNIT.1)";

    @LCASetter
    public void setPrevailingWage(String prevailingWage)
    {
	this.prevailingWage = prevailingWage;
    }

    // ----------------------------------------
    @LCA(pos = 19, type = "VARCHAR(100)")
    private String prevailingWageUnitOfPay;
    @LCARegex
    private String regexPrevailingWageUnitOfPay = "(PW)_(UNIT)(?!_2)";

    @LCASetter
    public void setPrevailingWageUnitOfPay(String prevailingWageUnitOfPay)
    {
	this.prevailingWageUnitOfPay = prevailingWageUnitOfPay;
    }

    // ----------------------------------------
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
    @LCA(pos = 21, type = "VARCHAR(100)")
    private String wageRateOfPay;
    @LCARegex
    private String regexWageRateOfPay = "(WAGE).*(RATE).*(PAY)";

    @LCASetter
    public void setWageRateOfPay(String wageRateOfPay)
    {
	this.wageRateOfPay = wageRateOfPay;
    }

    // ----------------------------------------
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
