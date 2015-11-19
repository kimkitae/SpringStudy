package macro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class FileControll implements FilenameFilter {
	static ArrayList<String> al = new ArrayList<String>();

	// ������ ���翩�θ� Ȯ���ϴ� �޼ҵ�
	public static Boolean fileIsLive(String isLivefile) {
		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// ������ �����ϴ� �޼ҵ�
	public static void fileMake(String infolder, String outfolder, String dir) {
		try {
			FileWriter fw = new FileWriter(dir + "\\" + "Path.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(infolder);
			bw.newLine();
			bw.write(outfolder);
			bw.newLine();
			bw.write(dir + "\\" + "tmp_macro.xlsm");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ������ �����ϴ� �޼ҵ�
	public static void fileDelete(String deleteFileName) {
		File I = new File(deleteFileName);
		I.delete();
	}

	// ������ �����ϴ� �޼ҵ�
	public static void fileCopy(String inFileName, String outFileName) {
		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			FileChannel fcin = fis.getChannel();
			FileChannel fout = fos.getChannel();

			long size = fcin.size();
			fcin.transferTo(0, size, fout);

			fout.close();
			fcin.close();

			fos.close();
			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ������ �̵��ϴ� �޼ҵ�
	public static void fileMove(String inFileName, String outFileName, String ouffolder) {
		try {
			System.out.println("���� �̵� " + ouffolder);
			File f = new File(ouffolder);
			if (!f.exists()) {
				f.mkdirs();
			}

			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			FileChannel fcin = fis.getChannel();
			FileChannel fout = fos.getChannel();

			long size = fcin.size();
			fcin.transferTo(0, size, fout);

			fout.close();
			fcin.close();

			fos.close();
			fis.close();

			// �����ѵ� ���������� ������
			fileDelete(inFileName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���丮�� ���� ����Ʈ�� �д� �޼ҵ�
	public static List<File> getDirFileList(String dirPath) {
		// ���丮 ���� ����Ʈ
		List<File> dirFileList = null;

		// ���� ����� ��û�� ���丮�� ������ ���� ��ü�� ������
		File dir = new File(dirPath);
		
		System.out.println("���ϸ���Ʈ�� �ҷ��� �� �ִ°�? dirPath = " + dirPath);

		// ���丮�� �����Ѵٸ�
		if (dir.exists()) {
			// ���� ����� ����
			File[] files = dir.listFiles();

			// ���� �迭�� ���� ����Ʈ�� ��ȭ��
			dirFileList = Arrays.asList(files);
		}

		return dirFileList;
	}

	public ArrayList<String> folderSearch(String dir) {
		FileControll fc = new FileControll();

		ArrayList<String> unique = null;
		
		unique = new ArrayList<String>(new LinkedHashSet<String>(fc.subDirList(dir)));
		
		//Ȯ�ο� for��
		for (String string : unique) {
			System.out.println("����ũ �� :" + string);
		}
		
		return unique;

	}

	public ArrayList<String> subDirList(String dir) {

		File folder = new File(dir);
		
		System.out.println("subDirList : dir = " + dir);
		
		File[] fileList = folder.listFiles();

		try {

			for (int i = 0; i < fileList.length; i++) {
				File file = fileList[i];
				if (file.isFile()) {
					accept(file, file.getCanonicalPath());
					// System.out.println(file.getParent());
					al.add(file.getParent());

				} else if (file.isDirectory()) {
					// System.out.println("���丮 �̸� = " + file.getName());

					// ������丮�� �����ϸ� ����� ������� �ٽ� Ž��
					subDirList(file.getCanonicalPath().toString());
				}

			}

		} catch (IOException e) {

		}

		return al;

	}

	public String pathChange(String dir) {
		ArrayList<String> aa = new ArrayList<String>();
		String dirs = dir;

		String[] patha = dirs.split("\\\\");

		patha[1] = "success";
		String pathChange = patha[0];

		for (int j = 1; j < patha.length; j++) {
			pathChange += "\\" + patha[j].toString();
		}

		return pathChange;
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.toLowerCase().endsWith(".xlsm");
	}

}