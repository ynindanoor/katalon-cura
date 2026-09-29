import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class common {
	@Keyword
	def loginSteps() {

		String username = 'John Doe'
		String password = 'ThisIsNotAPassword'

		WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/btn_makeAppointment'), 0)
		WebUI.click(findTestObject('Object Repository/login/btn_makeAppointment'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_username'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_username'), username)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_password'), password)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/btn_login'), 0)
		WebUI.click(findTestObject('Object Repository/login/btn_login'))		
	}
	
	@Keyword
	def makeAppointmentSteps() {
		String facility = 'Hongkong CURA Healthcare Center'
		String program = 'Medicaid'
		String date = '16/08/2026'
		String randomComment = "Test Comment " + UUID.randomUUID().toString().substring(0, 8)
		
		WebUI.verifyTextPresent('Make Appointment', false)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/select_facility'), 0)
		WebUI.selectOptionByValue(findTestObject('Object Repository/makeAppointment/select_facility'), facility, false)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/checkbox_hospitalReadmission'), 0)
		WebUI.click(findTestObject('Object Repository/makeAppointment/checkbox_hospitalReadmission'))
		
		TestObject radioProgram = new TestObject('radioProgram')
		radioProgram.addProperty('xpath', ConditionType.EQUALS,"//input[@type='radio' and @name='programs' and @value='${program}']")
		WebUI.click(radioProgram)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/input_visitDate'), 0)
		WebUI.setText(findTestObject('Object Repository/makeAppointment/input_visitDate'), date)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/input_comment'), 0)
		WebUI.setText(findTestObject('Object Repository/makeAppointment/input_comment'), randomComment)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/btn_bookAppointment'), 0)
		WebUI.click(findTestObject('Object Repository/makeAppointment/btn_bookAppointment'))
		
		WebUI.verifyTextPresent('Appointment Confirmation', false)
		WebUI.verifyTextPresent('Go to Homepage', false)
	
		WebUI.delay(5)
		WebUI.closeBrowser()
	}

}
