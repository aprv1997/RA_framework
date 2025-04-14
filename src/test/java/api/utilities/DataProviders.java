package api.utilities;

import java.io.IOException;
import api.utilities.ExcelReader;

import org.testng.annotations.DataProvider;

public class DataProviders{
	
	@DataProvider(name="data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		ExcelReader er = new ExcelReader(path);
		 
			int rownum = er.getRowCount("sheet1");
			int colcount=er.getCellCount("sheet1",1);
			String apidata[][]= new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					apidata[i-1][j]=er.getCellData("sheet1",i,j);
					
				}
			}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		ExcelReader er = new ExcelReader(path);
		int rownum=er.getRowCount("sheet1");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)		
		{
			apidata[i-1]=er.getCellData("sheet1",i,1);
			
		}
		    return apidata;            
	}

}
