package es.arquia.magnolia.components.architectureFiles.support.architect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.context.MgnlContext;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.UtilsConstants.*;


public class ArchitectureFilesSupportArchitect {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitect.class);

	private static String name = "FS1.1.1";
	private static String firstSurname = "FS1.1.2";
	private static String secondSurname = "FS1.1.3";
	private static String otherNames = "FS1.1.4";
	private static String photo = "FS1.1.5";
	private static String birthDate = "FS1.1.6";
	private static String birthCity = "FS1.1.7";
	private static String birthCountry = "FS1.1.8";
	
	private static String deathDate = "FS1.1.9.1";
	private static String deathCity = "FS1.1.9.2";
	private static String deathCountry = "FS1.1.9.3";
	
	private static String certification = "FS1.2.1";
	private static String certificationCenter = "FS1.2.2";
	private static String certificationCountry = "FS1.2.3";
	private static String certificationYear = "FS1.2.4";
	private static String otherStudies = "FS1.2.5";
	private static String doctorate = "FS1.2.6";
	
	private static String departmentName = "FS1.3.1";
	private static String departmentWebSite = "FS1.3.2";
	private static String departmentCity = "FS1.3.3";
	private static String departmentCountry = "FS1.3.4";
	private static String departmentComponents = "FS1.3.5";
	private static String biographicNews = "FS1.3.6";
	private static String curriculum = "FS1.3.7";
	private static String awardsAndDistinctions = "FS1.3.8";
	
	private static String workingExperienceStartDate = "FS1.4.1";
	private static String workingExperienceEndingDate = "FS1.4.2";
	private static String workingExperiencePositionOccupied = "FS1.4.3";
	private static String workingExperienceMainFunctions = "FS1.4.4";
	private static String workingExperienceBusinessName = "FS1.4.5";
	private static String workingExperienceBusinessType = "FS1.4.6";
	
	private static String educationStartDate = "FS1.5.1";
	private static String educationEndingDate = "FS1.5.2";
	private static String educationQualification = "FS1.5.3";
	private static String educationSubjects = "FS1.5.4";
	private static String educationCenter = "FS1.5.5";
	private static String educationCenterType = "FS1.5.6";
	private static String educationLevel = "FS1.5.7";
	
	private static String language = "FS1.6.1";
	private static String otherLanguages = "FS1.6.2";
	private static String motherLanguage = "FS1.6.3";
	private static String listening = "FS1.6.4";
	private static String reading = "FS1.6.5";
	private static String speakingInteraction = "FS1.6.6";
	private static String speakingExpression = "FS1.6.7";
	private static String writting = "FS1.6.8";
	
	private static String socialSkills = "FS1.7.1";
	private static String organizationalSkills = "FS1.7.2";
	private static String technicalSkills = "FS1.7.3";
	private static String computerSkills = "FS1.7.4";
	private static String artisticSkills = "FS1.7.5";
	private static String otherSkills = "FS1.7.6";
	private static String drivingLicense = "FS1.7.7";
	
	private static String aditionalInfo = "FS1.8.1";
	private static String annexes = "FS1.8.2";
	
	public ArchitectureFilesSupportArchitect() {}
	
	public String getName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(name).getString();
	}
	
	public String getFirstSurname(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(firstSurname).getString();
	}
	
	public String getSecondSurname(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(secondSurname).getString();
	}
	
	public String getOtherNames(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(otherNames).getString();
	}
	
	public String getPhoto(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(photo).getString();
	}
	
	public String getBirthDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(birthDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getBirthCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(birthCity).getString();
	}
	
	public String getBirthCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(birthCountry).getString();
	}
	
	public String getDeathDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(deathDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getDeathCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(deathCity).getString();
	}
	
	public String getDeathCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(deathCountry).getString();
	}
	
	public String getCertification(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(certification).getString();
	}
	
	public String getCertificationCenter(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(certificationCenter).getString();
	}
	
	public String getCertificatoinCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(certificationCountry).getString();
	}
	
	public String getCertificationYear(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(certificationYear).getString();
	}
	
	public String getOtherStudies(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(otherStudies).getString();
	}
	
	public String getDoctorate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(doctorate).getString();
	}
	
	public String getDepartmentName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(departmentName).getString();
	}
	
	public String getDepartmentWebSite(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentWebSite).getString();
	}
	
	public String getDepartmentCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentCity).getString();
	}
	
	public String getDepartmentCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentCountry).getString();
	}
	
	public List<String> getDepartmentComponents(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		List<String> list = new ArrayList<String>();
		for(Value iterator : node.getProperty(departmentComponents).getValues()) {
			list.add(iterator.getString());
		}
		return list;
	}
	
	public String getBiographicNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(biographicNews).getString();
	}
	
	public String getCurriculum(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(curriculum).getString();
	}
	
	public String getAwardsAndDistinctions(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(awardsAndDistinctions).getValues().toString();
	}
	
	public String getWorkingExperienceStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(workingExperienceStartDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getWorkingExperienceEndingDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(workingExperienceEndingDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getWorkingExperiencePositionOccupied(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(workingExperiencePositionOccupied).getString();
	}
	
	public String getWorkingExperienceMainFunctions(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(workingExperienceMainFunctions).getString();
	}
	
	public String getWorkingExperienceBusinessName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(workingExperienceBusinessName).getString();
	}
	
	public String getWorkingExperienceBusinessType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(workingExperienceBusinessType).getString();
	}
	
	public String getEducationStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(educationStartDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getEducationEndingDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(educationEndingDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getEducationQualification(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(educationQualification).getString();
	}
	
	public String getEducationSubjects(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(educationSubjects).getString();
	}
	
	public String getEducationCenter(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(educationCenter).getString();
	}
	
	public String getEducationCenterType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(educationCenterType).getString();
	}
	
	public String getEducationLevel(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(educationLevel).getString();
	}
	
	public String getLanguage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(language).getString();
	}
	
	public String getOtherLanguages(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(otherLanguages).getString();
	}
	
	public String getMotherLanguage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(motherLanguage).getString();
	}
	
	public String getListening(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(listening).getString();
	}
	
	public String getReading(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(reading).getString();
	}
	
	public String getSpeakingInteraction(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(speakingInteraction).getString();
	}
	
	public String getSpeakingExpression(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(speakingExpression).getString();
	}
	
	public String getWritting(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(writting).getString();
	}
	
	public String getSocialSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(socialSkills).getString();
	}
	
	public String getOrganizationalSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(organizationalSkills).getString();
	}
	
	public String getTechnicalSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(technicalSkills).getString();
	}
	
	public String getComputerSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(computerSkills).getString();
	}
	
	public String getArtisticSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(artisticSkills).getString();
	}
	
	public String getOtherSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(otherSkills).getString();
	}
	
	public String getDrivingLicense(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(drivingLicense).getString();
	}

	public String getAditionalInfo(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(aditionalInfo).getString();
	}
	
	public String getAnnexes(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(annexes).getValues().toString();
	}
}
