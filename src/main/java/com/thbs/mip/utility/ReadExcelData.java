package com.thbs.mip.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thbs.mip.dto.CustomerDetailsdto;
import com.thbs.mip.dto.Customerdto;
import com.thbs.mip.dto.Deactivationdto;
import com.thbs.mip.dto.EditCustomerDetailsdto;
import com.thbs.mip.dto.EditCustomerdto;
import com.thbs.mip.dto.NomineeDetailsdto;
import com.thbs.mip.dto.PaymentReactivationdto;
import com.thbs.mip.dto.ReactCustomerDetailsdto;
import com.thbs.mip.dto.ReactSubscriptionDetailsdto;
import com.thbs.mip.dto.RootCustomerdto;
import com.thbs.mip.dto.RootEditCustomerdto;
import com.thbs.mip.dto.RootReactCustomerdto;
import com.thbs.mip.dto.SubscriptionDetailsdto;
import com.thbs.mip.dto.UpdateCoverHistorydto;

public class ReadExcelData {


	public  List<RootCustomerdto> readRegData()
	{

		List<RootCustomerdto> rootcuslist = null;	

		try {

			FileInputStream fis =new FileInputStream("D:\\testdatanew.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sh = workbook.getSheet("regdata");

			rootcuslist=new ArrayList<RootCustomerdto>();
			//To get active rows
			int rownum=sh.getLastRowNum();
			//System.out.println("rownumber"+rownum);

			for(int i=1;i<=rownum;i++)
			{
				XSSFRow row = sh.getRow(i);


				/*
				 * Nominee and Beneficiary objects
				 * Nominee object for Life Product
				 * 
				 */

				NomineeDetailsdto nomDto;
				/*
				 * Nominee and Beneficiary objects for Hospital product
				 * 
				 */
				/*NomineeDetailsdto benefOneDto;
				NomineeDetailsdto benefTwoDto;
				NomineeDetailsdto benefThreeDto;*/

				//List of Life Nominee's
				List<NomineeDetailsdto> nomlist1 =new ArrayList<NomineeDetailsdto>();

				//List of Hosp Nominee's and Beneficiaries
				//List<NomineeDetailsdto> nomlist2 =new ArrayList<NomineeDetailsdto>();

				if(!sh.getRow(i).getCell(32).getStringCellValue().equals("null"))
				{

					nomDto= new NomineeDetailsdto();
					nomDto.setName(sh.getRow(i).getCell(32).getStringCellValue());
					nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(33).getStringCellValue()));
					nomDto.setMsisdn(sh.getRow(i).getCell(34).getStringCellValue());
					nomDto.setGender(sh.getRow(i).getCell(35).getStringCellValue());
					nomDto.setRelationship(sh.getRow(i).getCell(36).getStringCellValue());
					nomlist1.add(nomDto);
					//checkwhether 37 has value
					if(!sh.getRow(i).getCell(37).getStringCellValue().equals("null"))
					{

						nomDto= new NomineeDetailsdto();
						nomDto.setName(sh.getRow(i).getCell(37).getStringCellValue());
						nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(38).getStringCellValue()));
						nomDto.setMsisdn(sh.getRow(i).getCell(39).getStringCellValue());
						nomDto.setGender(sh.getRow(i).getCell(40).getStringCellValue());
						nomDto.setRelationship(sh.getRow(i).getCell(41).getStringCellValue());
						nomlist1.add(nomDto);
						//nomlist2.add(benefOneDto);

						/*String s=null;
						s=sh.getRow(i).getCell(42).getStringCellValue();
						System.out.println(s);
						if(null!=s)*/
						if(!sh.getRow(i).getCell(42).getStringCellValue().equals("null"))
						{

							nomDto= new NomineeDetailsdto();
							nomDto.setName(sh.getRow(i).getCell(42).getStringCellValue());
							nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(43).getStringCellValue()));
							nomDto.setMsisdn(sh.getRow(i).getCell(44).getStringCellValue());
							nomDto.setGender(sh.getRow(i).getCell(45).getStringCellValue());
							nomDto.setRelationship(sh.getRow(i).getCell(46).getStringCellValue());
							nomlist1.add(nomDto);

							if(!sh.getRow(i).getCell(47).getStringCellValue().equalsIgnoreCase("null"))
							{
								nomDto= new NomineeDetailsdto();
								nomDto.setName(sh.getRow(i).getCell(47).getStringCellValue());
								nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(48).getStringCellValue()));
								nomDto.setMsisdn(sh.getRow(i).getCell(49).getStringCellValue());
								nomDto.setGender(sh.getRow(i).getCell(50).getStringCellValue());
								nomDto.setRelationship(sh.getRow(i).getCell(51).getStringCellValue());
								nomlist1.add(nomDto);
							}
						}
					}
				}


				//List of Subscriptions
				List<SubscriptionDetailsdto> sublist=new ArrayList<SubscriptionDetailsdto>();
				/*
				 * Life subscriptions
				 * Hospital subscriptions
				 * 
				 */
				SubscriptionDetailsdto lifeSubDto;
				//SubscriptionDetailsdto hosSubDto=null;



				if(!sh.getRow(i).getCell(5).getStringCellValue().equals("null"))
				{
					/*
					 * true
					 * Capture Life details Mandatory
					 * 
					 */
					//System.out.println("Entered1 :"+i);
					lifeSubDto=new SubscriptionDetailsdto();
					lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(5).getStringCellValue()));
					lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(6).getStringCellValue()));
					lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(7).getStringCellValue()));
					lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(8).getStringCellValue());
					lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(9).getStringCellValue()));
					lifeSubDto.setDocumentValue(sh.getRow(i).getCell(10).getStringCellValue());
					lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(11).getStringCellValue()));
					lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(12).getStringCellValue()));
					lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(13).getStringCellValue()));
					lifeSubDto.setNomineeDetails(nomlist1);
					sublist.add(lifeSubDto);
					if (!sh.getRow(i).getCell(14).getStringCellValue().equals("null"))
					{  
						/*
						 * true
						 * Capture Hospital details Mandatory
						 * 
						 */
						//System.out.println("Entered1 :"+i);
						lifeSubDto=new SubscriptionDetailsdto();
						lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(14).getStringCellValue()));
						lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(15).getStringCellValue()));
						lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(16).getStringCellValue()));
						lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(17).getStringCellValue());
						lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(18).getStringCellValue()));
						lifeSubDto.setDocumentValue(sh.getRow(i).getCell(19).getStringCellValue());
						lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(22).getStringCellValue()));
						lifeSubDto.setNomineeDetails(nomlist1);
						sublist.add(lifeSubDto);

						if(!sh.getRow(i).getCell(23).getStringCellValue().equals("null"))
						{  
							/*
							 * true
							 * Capture Bundle details Mandatory
							 * 
							 */
							//System.out.println("Entered1 :"+i);
							lifeSubDto=new SubscriptionDetailsdto();
							lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
							lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(26).getStringCellValue());
							lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(27).getStringCellValue()));
							lifeSubDto.setDocumentValue(sh.getRow(i).getCell(28).getStringCellValue());
							lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(29).getStringCellValue()));
							lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(30).getStringCellValue()));
							lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(31).getStringCellValue()));
							lifeSubDto.setNomineeDetails(nomlist1);
							sublist.add(lifeSubDto);
						}
					}
					else{
						/*
						 * False
						 * NO Hospital product
						 * 
						 */

						if(!sh.getRow(i).getCell(23).getStringCellValue().equals("null"))
						{
							/*
							 * true
							 * Capture Bundle details Mandatory
							 * 
							 */
							//System.out.println("Entered1 :"+i);
							lifeSubDto=new SubscriptionDetailsdto();
							lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
							lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(26).getStringCellValue());
							lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(27).getStringCellValue()));
							lifeSubDto.setDocumentValue(sh.getRow(i).getCell(28).getStringCellValue());
							lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(29).getStringCellValue()));
							lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(30).getStringCellValue()));
							lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(31).getStringCellValue()));
							lifeSubDto.setNomineeDetails(nomlist1);
							sublist.add(lifeSubDto);

						}
					}
				}
				else
				{
					/*
					 * False
					 * NO Life product
					 * 
					 */
					if (!sh.getRow(i).getCell(14).getStringCellValue().equals("null"))
					{
						/*
						 * true
						 * Capture Hospital product
						 * 
						 */
						//System.out.println("Entered1 :"+i);
						lifeSubDto=new SubscriptionDetailsdto();
						lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(14).getStringCellValue()));
						lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(15).getStringCellValue()));
						lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(16).getStringCellValue()));
						lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(17).getStringCellValue());
						lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(18).getStringCellValue()));
						lifeSubDto.setDocumentValue(sh.getRow(i).getCell(19).getStringCellValue());
						lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(22).getStringCellValue()));
						lifeSubDto.setNomineeDetails(nomlist1);
						sublist.add(lifeSubDto);
						if(!sh.getRow(i).getCell(23).getStringCellValue().equals("null"))
						{   /*
						 * true
						 * Capture Bundle product
						 * 
						 */
							//System.out.println("Entered1 :"+i);
							lifeSubDto=new SubscriptionDetailsdto();
							lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
							lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(26).getStringCellValue());
							lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(27).getStringCellValue()));
							lifeSubDto.setDocumentValue(sh.getRow(i).getCell(28).getStringCellValue());
							lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(29).getStringCellValue()));
							lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(30).getStringCellValue()));
							lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(31).getStringCellValue()));
							lifeSubDto.setNomineeDetails(nomlist1);
							sublist.add(lifeSubDto);
						}
					}
					else{
						/*
						 * False
						 * NO Hospital product
						 * 
						 */
						if(!sh.getRow(i).getCell(23).getStringCellValue().equals("null"))
						{
							/*
							 * true
							 * Capture Bundle product
							 * 
							 */
							//System.out.println("Entered1 :"+i);
							lifeSubDto=new SubscriptionDetailsdto();
							lifeSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
							lifeSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
							lifeSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(26).getStringCellValue());
							lifeSubDto.setDocumentTypeId(Integer.parseInt(sh.getRow(i).getCell(27).getStringCellValue()));
							lifeSubDto.setDocumentValue(sh.getRow(i).getCell(28).getStringCellValue());
							lifeSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(29).getStringCellValue()));
							lifeSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(30).getStringCellValue()));
							lifeSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(31).getStringCellValue()));
							lifeSubDto.setNomineeDetails(nomlist1);
							sublist.add(lifeSubDto);
						}
					}
				}

				CustomerDetailsdto custDto=new CustomerDetailsdto();
				custDto.setCustomerName(sh.getRow(i).getCell(0).getStringCellValue());
				custDto.setCustomerAge(Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue()));
				custDto.setCustomerGender(sh.getRow(i).getCell(2).getStringCellValue());
				custDto.setCustomerMsisdn(sh.getRow(i).getCell(3).getStringCellValue());
				custDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(4).getStringCellValue()));
				custDto.setCreatedDate("2020-02-28 14:53:01");

				Customerdto cusdto=new Customerdto();
				cusdto.setCustomerDetails(custDto);
				cusdto.setCustomerSubscriptions(sublist);

				RootCustomerdto rootcusdto =new RootCustomerdto();
				rootcusdto.setCustomer(cusdto);

				rootcuslist.add(rootcusdto);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rootcuslist;
	}

	public List<Deactivationdto> readDeregData()
	{
		List<Deactivationdto> dereglist=null;
		try {
			FileInputStream fis=new FileInputStream("D:\\testdatanew.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("deregdata");
			int rownum = sh.getLastRowNum();
			dereglist=new ArrayList<Deactivationdto>();
			Deactivationdto deregdto;
			for(int i=1;i<=rownum;i++)
			{
				deregdto=new Deactivationdto();
				deregdto.setCustomerMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				deregdto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue()));
				deregdto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				deregdto.setDeactivationMode(Integer.parseInt(sh.getRow(i).getCell(3).getStringCellValue()));
				deregdto.setDeactivatedBy(Integer.parseInt(sh.getRow(i).getCell(4).getStringCellValue()));
				deregdto.setDeactivationDate(sh.getRow(i).getCell(5).getStringCellValue());
				dereglist.add(deregdto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dereglist;


	}

	public List<PaymentReactivationdto> readPaymentReactivatedata()
	{
		List<PaymentReactivationdto> reactlist = null;
		try{
			FileInputStream fis=new FileInputStream("D:\\testdatanew.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("paymentreactivatedata");
			int rownum=sh.getLastRowNum();
			reactlist=new ArrayList<PaymentReactivationdto>();
			PaymentReactivationdto reactdto;
			for(int i=1;i<=rownum;i++)
			{
				reactdto=new PaymentReactivationdto();
				reactdto.setCustomerMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				reactdto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue()));
				reactdto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				reactlist.add(reactdto);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return reactlist;
	}

	public List<String> readSearchData()
	{
		List<String> searchlist=null;
		try{
			FileInputStream fis=new FileInputStream("D:\\testdatanew.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("searchdata");
			int rownum = sh.getLastRowNum();
			searchlist=new ArrayList<String>();
			for(int i=1;i<=rownum;i++)
			{

				String msisdn=sh.getRow(i).getCell(0).getStringCellValue();
				searchlist.add(msisdn);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return searchlist;


	}
	public List<UpdateCoverHistorydto> readUpdateCover()
	{
		List<UpdateCoverHistorydto> coverlist=null;
		try{
			FileInputStream fis=new FileInputStream("D:\\testdatanew.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("updatecover");
			int rownum=sh.getLastRowNum();
			coverlist=new ArrayList<UpdateCoverHistorydto>();
			UpdateCoverHistorydto coverDto;
			for(int i=1;i<=rownum;i++)
			{
				coverDto=new UpdateCoverHistorydto();
				coverDto.setCustomerMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
				coverDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue()));
				coverDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				coverDto.setCreatedDate(sh.getRow(i).getCell(3).getStringCellValue());
				coverDto.setPaidAmount(sh.getRow(i).getCell(4).getStringCellValue());
				coverDto.setLifeCoverAmount(sh.getRow(i).getCell(5).getStringCellValue());
				coverDto.setHealthCoverAmount(sh.getRow(i).getCell(6).getStringCellValue());
				coverDto.setCoverStartDate(sh.getRow(i).getCell(7).getStringCellValue());
				coverDto.setCoverEndDate(sh.getRow(i).getCell(8).getStringCellValue());
				coverlist.add(coverDto);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return coverlist;
	}

	public List<RootReactCustomerdto> readSubReactData()
	{
		List<RootReactCustomerdto> reactlist=null;
		try{
		FileInputStream fis=new FileInputStream("D:\\testdatanew.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("subreactivationdata");
		int rownum=sh.getLastRowNum();
		
		reactlist=new ArrayList<RootReactCustomerdto>();
		for(int i=1;i<=rownum;i++)
		{
			NomineeDetailsdto nomDto;
			List<NomineeDetailsdto> nomlist=new ArrayList<NomineeDetailsdto>();
			if(!sh.getRow(i).getCell(28).getStringCellValue().equals("null"))
			{
				
				nomDto= new NomineeDetailsdto();
				nomDto.setName(sh.getRow(i).getCell(28).getStringCellValue());
				nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(29).getStringCellValue()));
				nomDto.setMsisdn(sh.getRow(i).getCell(30).getStringCellValue());
				nomDto.setGender(sh.getRow(i).getCell(31).getStringCellValue());
				nomDto.setRelationship(sh.getRow(i).getCell(32).getStringCellValue());
				nomlist.add(nomDto);
				//checkwhether 34 has value
				if(!sh.getRow(i).getCell(33).getStringCellValue().equals("null"))
				{

					nomDto= new NomineeDetailsdto();
					nomDto.setName(sh.getRow(i).getCell(33).getStringCellValue());
					nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(34).getStringCellValue()));
					nomDto.setMsisdn(sh.getRow(i).getCell(35).getStringCellValue());
					nomDto.setGender(sh.getRow(i).getCell(36).getStringCellValue());
					nomDto.setRelationship(sh.getRow(i).getCell(37).getStringCellValue());
					nomlist.add(nomDto);
					//nomlist2.add(benefOneDto);

					/*String s=null;
					s=sh.getRow(i).getCell(42).getStringCellValue();
					System.out.println(s);
					if(null!=s)*/
					if(!sh.getRow(i).getCell(38).getStringCellValue().equals("null"))
					{

						nomDto= new NomineeDetailsdto();
						nomDto.setName(sh.getRow(i).getCell(38).getStringCellValue());
						nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(39).getStringCellValue()));
						nomDto.setMsisdn(sh.getRow(i).getCell(40).getStringCellValue());
						nomDto.setGender(sh.getRow(i).getCell(41).getStringCellValue());
						nomDto.setRelationship(sh.getRow(i).getCell(42).getStringCellValue());
						nomlist.add(nomDto);

						if(!sh.getRow(i).getCell(43).getStringCellValue().equalsIgnoreCase("null"))
						{
							nomDto= new NomineeDetailsdto();
							nomDto.setName(sh.getRow(i).getCell(43).getStringCellValue());
							nomDto.setAge(Integer.parseInt(sh.getRow(i).getCell(44).getStringCellValue()));
							nomDto.setMsisdn(sh.getRow(i).getCell(45).getStringCellValue());
							nomDto.setGender(sh.getRow(i).getCell(46).getStringCellValue());
							nomDto.setRelationship(sh.getRow(i).getCell(47).getStringCellValue());
							nomlist.add(nomDto);
						}
					}
				}
			}
			
			//List of Subscriptions
			List<ReactSubscriptionDetailsdto> sublist=new ArrayList<ReactSubscriptionDetailsdto>();
			/*
			 * Life subscriptions
			 * Hospital subscriptions
			 * 
			 */
			ReactSubscriptionDetailsdto reactSubDto;
			//SubscriptionDetailsdto hosSubDto=null;



			if(!sh.getRow(i).getCell(1).getStringCellValue().equals("null"))
			{
				/*
				 * true
				 * Capture Life details Mandatory
				 * 
				 */
				//System.out.println("Entered1 :"+i);
				reactSubDto=new ReactSubscriptionDetailsdto();
				reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(1).getStringCellValue()));
				reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(2).getStringCellValue()));
				reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(3).getStringCellValue()));
				reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(4).getStringCellValue());
				reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(5).getStringCellValue()));
				reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(6).getStringCellValue()));
				reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(7).getStringCellValue()));
				reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(8).getStringCellValue()));
				reactSubDto.setCreatedDate(sh.getRow(i).getCell(9).getStringCellValue());
				reactSubDto.setNomineeDetails(nomlist);
				sublist.add(reactSubDto);
				if (!sh.getRow(i).getCell(10).getStringCellValue().equals("null"))
				{  
					/*
					 * true
					 * Capture Hospital details Mandatory
					 * 
					 */
					//System.out.println("Entered1 :"+i);
					reactSubDto=new ReactSubscriptionDetailsdto();
					reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(10).getStringCellValue()));
					reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(11).getStringCellValue()));
					reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(12).getStringCellValue()));
					reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(13).getStringCellValue());
					reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(14).getStringCellValue()));
					reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(15).getStringCellValue()));
					reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(16).getStringCellValue()));
					reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(17).getStringCellValue()));
					reactSubDto.setCreatedDate(sh.getRow(i).getCell(18).getStringCellValue());
					reactSubDto.setNomineeDetails(nomlist);
					sublist.add(reactSubDto);

					if(!sh.getRow(i).getCell(19).getStringCellValue().equals("null"))
					{  
						/*
						 * true
						 * Capture Bundle details Mandatory
						 * 
						 */
						//System.out.println("Entered1 :"+i);
						reactSubDto=new ReactSubscriptionDetailsdto();
						reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(19).getStringCellValue()));
						reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(22).getStringCellValue());
						reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
						reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
						reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
						reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(26).getStringCellValue()));
						reactSubDto.setCreatedDate(sh.getRow(i).getCell(27).getStringCellValue());
						reactSubDto.setNomineeDetails(nomlist);
						sublist.add(reactSubDto);
					}
				}
				else{
					/*
					 * False
					 * NO Hospital product
					 * 
					 */

					if(!sh.getRow(i).getCell(19).getStringCellValue().equals("null"))
					{
						/*
						 * true
						 * Capture Bundle details Mandatory
						 * 
						 */
						//System.out.println("Entered1 :"+i);
						reactSubDto=new ReactSubscriptionDetailsdto();
						reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(19).getStringCellValue()));
						reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(22).getStringCellValue());
						reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
						reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
						reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
						reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(26).getStringCellValue()));
						reactSubDto.setCreatedDate(sh.getRow(i).getCell(27).getStringCellValue());
						reactSubDto.setNomineeDetails(nomlist);
						sublist.add(reactSubDto);

					}
				}
			}
			else
			{
				/*
				 * False
				 * NO Life product
				 * 
				 */
				if (!sh.getRow(i).getCell(10).getStringCellValue().equals("null"))
				{
					/*
					 * true
					 * Capture Hospital product
					 * 
					 */
					//System.out.println("Entered1 :"+i);
					reactSubDto=new ReactSubscriptionDetailsdto();
					reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(10).getStringCellValue()));
					reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(11).getStringCellValue()));
					reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(12).getStringCellValue()));
					reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(13).getStringCellValue());
					reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(14).getStringCellValue()));
					reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(15).getStringCellValue()));
					reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(16).getStringCellValue()));
					reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(17).getStringCellValue()));
					reactSubDto.setCreatedDate(sh.getRow(i).getCell(18).getStringCellValue());
					reactSubDto.setNomineeDetails(nomlist);
					sublist.add(reactSubDto);
					if(!sh.getRow(i).getCell(19).getStringCellValue().equals("null"))
					{   /*
					 * true
					 * Capture Bundle product
					 * 
					 */
						//System.out.println("Entered1 :"+i);
						reactSubDto=new ReactSubscriptionDetailsdto();
						reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(19).getStringCellValue()));
						reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(22).getStringCellValue());
						reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
						reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
						reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
						reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(26).getStringCellValue()));
						reactSubDto.setCreatedDate(sh.getRow(i).getCell(27).getStringCellValue());
						reactSubDto.setNomineeDetails(nomlist);
						sublist.add(reactSubDto);
					}
				}
				else{
					/*
					 * False
					 * NO Hospital product
					 * 
					 */
					if(!sh.getRow(i).getCell(19).getStringCellValue().equals("null"))
					{
						/*
						 * true
						 * Capture Bundle product
						 * 
						 */
						//System.out.println("Entered1 :"+i);
						reactSubDto=new ReactSubscriptionDetailsdto();
						reactSubDto.setOfferId(Integer.parseInt(sh.getRow(i).getCell(19).getStringCellValue()));
						reactSubDto.setOfferCoverId(Integer.parseInt(sh.getRow(i).getCell(20).getStringCellValue()));
						reactSubDto.setHealthTipsSmsFrequency(Integer.parseInt(sh.getRow(i).getCell(21).getStringCellValue()));
						reactSubDto.setHealthTipsSmsLang(sh.getRow(i).getCell(22).getStringCellValue());
						reactSubDto.setPaymentConfigurationId(Integer.parseInt(sh.getRow(i).getCell(23).getStringCellValue()));
						reactSubDto.setRegisteredChannelId(Integer.parseInt(sh.getRow(i).getCell(24).getStringCellValue()));
						reactSubDto.setPaymentChannelId(Integer.parseInt(sh.getRow(i).getCell(25).getStringCellValue()));
						reactSubDto.setCreatedBy(Integer.parseInt(sh.getRow(i).getCell(26).getStringCellValue()));
						reactSubDto.setCreatedDate(sh.getRow(i).getCell(27).getStringCellValue());
						reactSubDto.setNomineeDetails(nomlist);
						sublist.add(reactSubDto);
					}
				}
			}
			
			ReactCustomerDetailsdto reactivateCustomer=new ReactCustomerDetailsdto();
			reactivateCustomer.setCustomerMsisdn(sh.getRow(i).getCell(0).getStringCellValue());
			reactivateCustomer.setCustomerSubscriptions(sublist);
			
			RootReactCustomerdto rootDto=new RootReactCustomerdto();
			rootDto.setReactivateCustomer(reactivateCustomer);
			
			reactlist.add(rootDto);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return reactlist;
	}
	
	
	

	public static void main(String[] args)
	{
		ReadExcelData red=new ReadExcelData();
/*		List<RootCustomerdto> customerdata = red.readRegData();
		//Conversion of object to JSON
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		for(RootCustomerdto cus : customerdata)
		{
			try{
				jsonStr = Obj.writeValueAsString(cus);
				System.out.println(jsonStr);
			}
			catch (Exception e) {

				e.printStackTrace();
			}
		}
		List<Deactivationdto> der = red.readDeregData();
		String deregJsonStr=null;
		for(Deactivationdto deact: der)
		{
			try {
				deregJsonStr=Obj.writeValueAsString(deact);
				System.out.println(deregJsonStr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<PaymentReactivationdto> reac = red.readPaymentReactivatedata();
		String reactJsonStr=null;
		for(PaymentReactivationdto react: reac)
		{
			try {
				reactJsonStr=Obj.writeValueAsString(react);
				System.out.println(reactJsonStr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<UpdateCoverHistorydto> cover = red.readUpdateCover();
		String coverJsonStr=null;
		for(UpdateCoverHistorydto react: cover)
		{
			try {
				reactJsonStr=Obj.writeValueAsString(react);
				System.out.println(reactJsonStr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		List<RootReactCustomerdto> reactSubDto = red.readSubReactData();
		String reactSubJsonStr=null;
		ObjectMapper Obj = new ObjectMapper();
		for(RootReactCustomerdto reactSubObj: reactSubDto)
		{
			try {
				reactSubJsonStr=Obj.writeValueAsString(reactSubObj);
				System.out.println(reactSubJsonStr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}		

}




