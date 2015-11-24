package macro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Macro;
import spring.MemberDao;

public class ExtendThreadtmp implements Runnable {
	static String DIR = System.getProperty("user.dir");
	static boolean XLSM = false;
	static FileControll fc;
	static ExcelExecute ee;
	static ProcessSearch ps;
	private static MemberDao memberDao;
	
	@Override
	public void run() {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		
		String inFolder = "D:\\MacroImport";
		String outFolder = "D:\\ODBC";
		
		try {
			Macro macro = new Macro("START", "Ing..");
			memberDao.macroInsert(macro);
			fc = new FileControll();
			ee = new ExcelExecute();
			ps = new ProcessSearch();
			List<File> fileList = null;
			String folderSelect = "";
			ArrayList<String> folderdd = new ArrayList<String>();

			fileList = fc.getDirFileList(outFolder);
			for (int h = 0; h <= fileList.size(); h++) {
				if (fileList.size() >= 0) {
					break;
				} else {
					fc.fileDelete(outFolder + "\\" + fileList.get(h).getName().toString());
				}
			}

			for (int i = 0; i < fc.folderSearch(inFolder).size(); i++) {
				folderSelect = fc.folderSearch(inFolder).get(i).toString();
				fc.fileMake(folderSelect, outFolder, DIR);
				System.out.println(folderSelect+ " / "+ outFolder+" / "+ DIR);

				fileList = fc.getDirFileList(folderSelect);

				for (int j = 0; j < fileList.size(); j++) {
					String fileName = fileList.get(j).getName();
					fc.fileCopy(folderSelect + "\\" + fileName, outFolder + "\\" + fileName);
				}
				ee.test1();
				while (ps.result() != false) {
					if (ps.result() != false) {
					} else {
					}
					Thread.sleep(2000);
				}
				for (int h = 0; h < fileList.size(); h++) {
					Thread.sleep(1500);
					fc.fileDelete(outFolder + "\\" + fileList.get(h).getName().toString());
				}
			}
			for (int i = 0; i < fc.folderSearch(inFolder).size(); i++) {
				folderSelect = fc.folderSearch(inFolder).get(i).toString();
				fileList = fc.getDirFileList(folderSelect);

				for (int j = 0; j < fileList.size(); j++) {

					String fileName = fileList.get(j).getName();

					if (fileName.endsWith(".xlsm") == true) {
						XLSM = true;
					}
				}
				if (XLSM == true) {
					for (int k = 0; k < fileList.size(); k++) {

						String fileName = fileList.get(k).getName();

						fc.fileMove(folderSelect + "\\" + fileName, fc.pathChange(folderSelect) + "\\" + fileName,
								fc.pathChange(folderSelect));

					}

					XLSM = false;
					File f = new File(folderSelect);
					f.delete();
				}

			}

		} catch (InterruptedException e) {
			Macro macro = new Macro("STOP", "InterruptedException");
			memberDao.macroInsert(macro);
		} catch (IOException e) {
			Macro macro = new Macro("STOP", "IOException");
			memberDao.macroInsert(macro);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Macro macro = new Macro("STOP", "PASS");
		memberDao.macroInsert(macro);
		ctx.close();
	}
}

