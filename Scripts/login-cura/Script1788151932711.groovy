import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

		WebUI.openBrowser(GlobalVariable.baseUrl)
		WebUI.maximizeWindow()
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/btn_makeAppointment'), 0)
		WebUI.click(findTestObject('Object Repository/login/btn_makeAppointment'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_username'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_username'), username)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/input_password'), 0)
		WebUI.setText(findTestObject('Object Repository/login/input_password'), password)
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/login/btn_login'), 0)
		WebUI.click(findTestObject('Object Repository/login/btn_login'))		
		
		if(testType == 'P') {
			WebUI.verifyElementPresent(findTestObject('Object Repository/makeAppointment/select_facility'), 0)
		} else {
			WebUI.verifyTextPresent('Login failed! Please ensure the username and password are valid.', false)
		}
		
		WebUI.closeBrowser()