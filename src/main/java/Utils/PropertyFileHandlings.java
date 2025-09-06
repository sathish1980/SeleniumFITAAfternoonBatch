package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandlings {
	
	static String  filePath = System.getProperty("user.dir")+"\\Environment\\Env.Properties";
	
	public static Properties ReadFile() throws IOException
	{
		File F = new File(filePath);
		FileInputStream FS = new FileInputStream(F);
		Properties P = new Properties();
		P.load(FS);
		/*System.out.println(P.getProperty("name"));
		System.out.println(P.getProperty("age"));
		String currentname = P.getProperty("name");
		if(currentname.equalsIgnoreCase("Raja"))
		{
			P.setProperty("Name", "FITA");
		}
		System.out.println(P.getProperty("Value"));
		
		FS.close();*/
		return P;
	}

}
