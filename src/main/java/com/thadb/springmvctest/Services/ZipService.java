package com.thadb.springmvctest.Services;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Service;

import com.thadb.springmvctest.dao.Champion;
import com.thadb.springmvctest.dao.Item;
import com.thadb.springmvctest.dao.User;
import com.thadb.springmvctest.enums.ItemType;


@Service
public class ZipService{

	public ZipService(){
	}

	public File getFileFor(User user) {
		Random rand = new Random();
		long tempId = rand.nextLong();
		createFileStructure(user, tempId);
		zipFileStructure(tempId);
		return packageJar(tempId);
	}
	
	  private File getZip(long tempId) {
		  File zipFile = new File(System.getProperty("user.home")+"/tempfiles/"+tempId+"/data.zip");
		  return zipFile;
	}

	  private File packageJar(long tempId){
		  File baseJar = new File(System.getProperty("user.home")+"/jar/base.jar");
		  File outJar = new File(System.getProperty("user.home")+"/tempfiles/"+tempId+"/installer.jar");
		  File zipFile = getZip(tempId);
		  try {
			addFileToJar(baseJar, outJar, zipFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  return outJar;
	  }



	private void zipFileStructure(long tempId) {
		File baseDirectory = new File(System.getProperty("user.home")+"/tempfiles/"+tempId+"/champData/Characters");
		File zipFile = new File(System.getProperty("user.home")+"/tempfiles/"+tempId+"/data.zip");
		try {
			zip(baseDirectory, zipFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}



	public void createFileStructure(User user, long tempId) {
		 File baseDirectory = new File(System.getProperty("user.home")+"/tempfiles/"+tempId+"/champData/Characters/");
		for (Champion c : user.getSelectedChamps()){
			File champDir = new File(baseDirectory.getAbsolutePath()+"/"+c.getFolderName());
			champDir.mkdirs();
			//Create Champion File - RecItemsCLASSIC.ini			
			File champFile = new File(champDir.getAbsolutePath()+"/RecItemsCLASSIC.ini");
            try {
            	champFile.createNewFile();            
            	BufferedWriter bw = new BufferedWriter(new FileWriter(champFile, true));
            	bw.write("[ItemSet1]");
				bw.newLine();
				bw.write("SetName=Set1");
				bw.newLine();
				int counter = 0;
				for (Item i : c.getSelectedItems()){
					counter++;
					bw.write("RecItem"+counter+"="+i.getItemCode());
					bw.newLine();
				}
				if (counter < 6){
					for (int i = counter; i <=6; i++){
						bw.write("RecItem"+counter+"=0000");
						bw.newLine();
					}
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	public static void zip(File directory, File zipfile) throws IOException {
		    URI base = directory.toURI();
		    Deque<File> queue = new LinkedList<File>();
		    queue.push(directory);
		    OutputStream out = new FileOutputStream(zipfile);
		    Closeable res = out;
		    try {
		      ZipOutputStream zout = new ZipOutputStream(out);
		      res = zout;
		      while (!queue.isEmpty()) {
		        directory = queue.pop();
		        for (File kid : directory.listFiles()) {
		          String name = base.relativize(kid.toURI()).getPath();
		          if (kid.isDirectory()) {
		            queue.push(kid);
		            name = name.endsWith("/") ? name : name + "/";
		            zout.putNextEntry(new ZipEntry(name));
		          } else {
		            zout.putNextEntry(new ZipEntry(name));
		            copy(kid, zout);
		            zout.closeEntry();
		          }
		        }
		      }
		    } finally {
		      res.close();
		    }
		  }
	  
	  private static void copy(InputStream in, OutputStream out) throws IOException {
		    byte[] buffer = new byte[1024];
		    while (true) {
		      int readCount = in.read(buffer);
		      if (readCount < 0) {
		        break;
		      }
		      out.write(buffer, 0, readCount);
		    }
		  }

		  private static void copy(File file, OutputStream out) throws IOException {
		    InputStream in = new FileInputStream(file);
		    try {
		      copy(in, out);
		    } finally {
		      in.close();
		    }
		  }

		  @SuppressWarnings("unused")
		private static void copy(InputStream in, File file) throws IOException {
		    OutputStream out = new FileOutputStream(file);
		    try {
		      copy(in, out);
		    } finally {
		      out.close();
		    }
		  }
		  
		  public static void addFileToJar(File sourceJar, File newJar, File fileToAdd) throws IOException{


			    // Open the jar file.
			    JarFile jar = new JarFile(sourceJar);
			    System.out.println(sourceJar.getAbsolutePath() + " opened.");

			    try {
			       // Create a temp jar file with no manifest. (The manifest will
			       // be copied when the entries are copied.)
			       Manifest jarManifest = jar.getManifest();
			       JarOutputStream tempJar = new JarOutputStream(new FileOutputStream(newJar));

			       // Allocate a buffer for reading entry data.
			       byte[] buffer = new byte[1024];
			       int bytesRead;

			       try {
			          // Open the given file.
			          FileInputStream file = new FileInputStream(fileToAdd);

			          try {
			             // Create a jar entry and add it to the temp jar.
			             JarEntry entry = new JarEntry(fileToAdd.getName());
			             tempJar.putNextEntry(entry);
			             // Read the file and write it to the jar.
			             while ((bytesRead = file.read(buffer)) != -1) {
			                tempJar.write(buffer, 0, bytesRead);
			             }
			             System.out.println(entry.getName() + " added.");
			          }
			          finally {
			             file.close();
			          }

			          // Loop through the jar entries and add them to the temp jar,
			          // skipping the entry that was added to the temp jar already.
			          for (Enumeration entries = jar.entries(); entries.hasMoreElements(); ) {
			             // Get the next entry.

			             JarEntry entry = (JarEntry) entries.nextElement();

			             // If the entry has not been added already, add it.

			             if (! entry.getName().equals(fileToAdd.getName())) {
			                // Get an input stream for the entry.

			                InputStream entryStream = jar.getInputStream(entry);

			                // Read the entry and write it to the temp jar.

			                tempJar.putNextEntry(entry);

			                while ((bytesRead = entryStream.read(buffer)) != -1) {
			                   tempJar.write(buffer, 0, bytesRead);
			                }
			             }
			          }
			       }
			       catch (Exception ex) {
			          System.out.println(ex);
			          // Add a stub entry here, so that the jar will close without an
			          // exception.
			          tempJar.putNextEntry(new JarEntry("stub"));
			       }
			       finally {
			          tempJar.close();
			       }
			    }
			    finally {
			       jar.close();
			       System.out.println(sourceJar.getAbsolutePath() + " closed.");
			    }	
			}
}
