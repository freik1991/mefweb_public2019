package hacom.pe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import sun.misc.BASE64Encoder;

public class ManagerArchivo {

    private String nombreFile;
    private String codigoFile;
    private boolean renderFileName = false;
    private UploadedFile fileUpload;
	private StreamedContent file;
    
	public ManagerArchivo(String codigoFile, String nombreFile) {
		this.codigoFile = codigoFile;
		this.nombreFile = nombreFile;
	}
	
	public ManagerArchivo() {
		super();
	}

	public String getNombreFile() {
		return nombreFile;
	}


	public void setNombreFile(String nombreFile) {
		this.nombreFile = nombreFile;
	}


	public String getCodigoFile() {
		return codigoFile;
	}


	public void setCodigoFile(String codigoFile) {
		this.codigoFile = codigoFile;
	}


	public boolean isRenderFileName() {
		return renderFileName;
	}

	public void setRenderFileName(boolean renderFileName) {
		this.renderFileName = renderFileName;
	}

	public UploadedFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(UploadedFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	public StreamedContent getFile() {
		try {
			InputStream stream = new FileInputStream(SistConstants.DIRECTORIOFILE + codigoFile);
			file = new DefaultStreamedContent(stream, "application/pdf",nombreFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
    
	public void GrabarArchivo(){
		codigoFile = GenerarNombreArchivo();
		nombreFile = fileUpload.getFileName();
		try {
			copyFile(codigoFile, fileUpload.getInputstream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile(String fileName, InputStream in) throws Exception {
		OutputStream out = new FileOutputStream(new File(
				SistConstants.DIRECTORIOFILE + fileName));
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = in.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		in.close();
		out.flush();
		out.close();
	}
	
//	public void handle(FileUploadEvent event) {
//		fileUpload = event.getFile();
//		nombreFile = fileUpload.getFileName();
//        renderFileName = true;
//        // To Clear Any Error Messages
//        RequestContext.getCurrentInstance().execute("jQuery(\"div.fileupload-content tr.ui-state-error\").remove();");
//    }
	
	public static String GenerarNombreArchivo() {
		String cadenaAleatoria = "";
		File fichero;
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		while (true) {
			cadenaAleatoria = "";
			int i = 0;
			while (i < 20) {
				char c = (char) r.nextInt(255);
				if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
					cadenaAleatoria += c;
					i++;
				}
			}
			fichero = new File(SistConstants.DIRECTORIOFILE+cadenaAleatoria+".jpg");			
			if (!fichero.exists()){
				break;
			}
		}
		return cadenaAleatoria;
	}
	
	/**
	 * Convierte arreglo de bytes en string codificado
	 * @param byte[] image, imagen convertida en un arreglo de bytes
	 * @return  string
	 */
	public static String getEncode(byte[] image) {
			return new BASE64Encoder().encode(image);
	}
	
}
