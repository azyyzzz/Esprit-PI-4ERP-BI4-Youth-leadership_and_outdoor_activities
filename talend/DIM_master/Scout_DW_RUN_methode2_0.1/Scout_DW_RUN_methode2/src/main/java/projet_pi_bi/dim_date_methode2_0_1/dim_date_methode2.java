// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package projet_pi_bi.dim_date_methode2_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: dim_date_methode2 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class dim_date_methode2 implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "dim_date_methode2";
	private final String projectName = "PROJET_PI_BI";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				dim_date_methode2.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(dim_date_methode2.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tRowGenerator_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRowGenerator_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRow_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_date_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[0];

	
			    public java.util.Date full_date;

				public java.util.Date getFull_date () {
					return this.full_date;
				}
				
			    public Integer date_id;

				public Integer getDate_id () {
					return this.date_id;
				}
				
			    public String jour_nom;

				public String getJour_nom () {
					return this.jour_nom;
				}
				
			    public String mois_nom;

				public String getMois_nom () {
					return this.mois_nom;
				}
				
			    public Integer annee;

				public Integer getAnnee () {
					return this.annee;
				}
				
			    public Integer trimestre;

				public Integer getTrimestre () {
					return this.trimestre;
				}
				
			    public String saison;

				public String getSaison () {
					return this.saison;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_date_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_date_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_date_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_date_methode2, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_date_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_date_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_date_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_date_methode2, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_date_methode2) {

        	try {

        		int length = 0;
		
					this.full_date = readDate(dis);
					
						this.date_id = readInteger(dis);
					
					this.jour_nom = readString(dis);
					
					this.mois_nom = readString(dis);
					
						this.annee = readInteger(dis);
					
						this.trimestre = readInteger(dis);
					
					this.saison = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_date_methode2) {

        	try {

        		int length = 0;
		
					this.full_date = readDate(dis);
					
						this.date_id = readInteger(dis);
					
					this.jour_nom = readString(dis);
					
					this.mois_nom = readString(dis);
					
						this.annee = readInteger(dis);
					
						this.trimestre = readInteger(dis);
					
					this.saison = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.full_date,dos);
					
					// Integer
				
						writeInteger(this.date_id,dos);
					
					// String
				
						writeString(this.jour_nom,dos);
					
					// String
				
						writeString(this.mois_nom,dos);
					
					// Integer
				
						writeInteger(this.annee,dos);
					
					// Integer
				
						writeInteger(this.trimestre,dos);
					
					// String
				
						writeString(this.saison,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.full_date,dos);
					
					// Integer
				
						writeInteger(this.date_id,dos);
					
					// String
				
						writeString(this.jour_nom,dos);
					
					// String
				
						writeString(this.mois_nom,dos);
					
					// Integer
				
						writeInteger(this.annee,dos);
					
					// Integer
				
						writeInteger(this.trimestre,dos);
					
					// String
				
						writeString(this.saison,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("full_date="+String.valueOf(full_date));
		sb.append(",date_id="+String.valueOf(date_id));
		sb.append(",jour_nom="+jour_nom);
		sb.append(",mois_nom="+mois_nom);
		sb.append(",annee="+String.valueOf(annee));
		sb.append(",trimestre="+String.valueOf(trimestre));
		sb.append(",saison="+saison);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_date_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_date_methode2 = new byte[0];

	
			    public Integer id;

				public Integer getId () {
					return this.id;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_date_methode2) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_date_methode2) {

        	try {

        		int length = 0;
		
						this.id = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tRowGenerator_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tDBOutput_1 = 0;
		



int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;
String dbschema_tDBOutput_1 = null;
String tableName_tDBOutput_1 = null;
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","0001-01-01").getTime();
long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","1753-01-01").getTime();
long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss","9999-12-31 24:00:00").getTime();
long date_tDBOutput_1;

java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));



	
java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;
    dbschema_tDBOutput_1 = "dbo";
    String driverClass_tDBOutput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
    java.lang.Class.forName(driverClass_tDBOutput_1);
    String port_tDBOutput_1 = "1433";
    String dbname_tDBOutput_1 = "scout_DW" ;
    String url_tDBOutput_1 = "jdbc:sqlserver://" + "localhost" ; 
    if (!"".equals(port_tDBOutput_1)) {
    	url_tDBOutput_1 += ":" + "1433";
    }
    if (!"".equals(dbname_tDBOutput_1)) {		    
		    	url_tDBOutput_1 += ";databaseName=" + "scout_DW"; 
	
    }
    url_tDBOutput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
    dbUser_tDBOutput_1 = "talend_user";

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:QTRQgwDKfnYDvWAiNvHzsSEbz/Sa53dnf0BDi6upbaS1ix0iXNU=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "dim_date";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "dim_date";
}
	int count_tDBOutput_1=0;

                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.Statement isExistStmt_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                    try {
                                        isExistStmt_tDBOutput_1.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_1 + "]" );
                                        whetherExist_tDBOutput_1 = true;
                                    } catch (java.lang.Exception e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                                        whetherExist_tDBOutput_1 = false;
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([full_date] DATETIME ,[date_id] INT ,[jour_nom] VARCHAR(0)  ,[mois_nom] VARCHAR(0)  ,[annee] INT ,[trimestre] INT ,[saison] VARCHAR(0)  )");
                                    }
                                }
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([full_date],[date_id],[jour_nom],[mois_nom],[annee],[trimestre],[saison]) VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
	java.util.Date maDate;
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tRowGenerator_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRowGenerator_1", false);
		start_Hash.put("tRowGenerator_1", System.currentTimeMillis());
		
	
	currentComponent="tRowGenerator_1";

	
		int tos_count_tRowGenerator_1 = 0;
		


int nb_line_tRowGenerator_1 = 0;
int nb_max_row_tRowGenerator_1 = 26000;


class tRowGenerator_1Randomizer {
	public Integer getRandomid() {
		
		return Numeric.sequence("s1" ,0 ,1 );
		
	}
}
	tRowGenerator_1Randomizer randtRowGenerator_1 = new tRowGenerator_1Randomizer();
	
	for (int itRowGenerator_1=0; itRowGenerator_1<nb_max_row_tRowGenerator_1 ;itRowGenerator_1++) {
		row1.id = randtRowGenerator_1.getRandomid();
		nb_line_tRowGenerator_1++;
		

 



/**
 * [tRowGenerator_1 begin ] stop
 */
	
	/**
	 * [tRowGenerator_1 main ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 


	tos_count_tRowGenerator_1++;

/**
 * [tRowGenerator_1 main ] stop
 */
	
	/**
	 * [tRowGenerator_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;
Var.maDate = TalendDate.addDate(TalendDate.parseDate("yyyy-MM-dd", "1960-01-01"), row1.id, "dd") ;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.full_date = Var.maDate ;
out1_tmp.date_id = Integer.parseInt(TalendDate.formatDate("yyyyMMdd", Var.maDate)) ;
out1_tmp.jour_nom = TalendDate.formatDate("EEEE", Var.maDate) ;
out1_tmp.mois_nom = TalendDate.formatDate("MMMM", Var.maDate);
out1_tmp.annee = TalendDate.getPartOfDate("YEAR", Var.maDate) ;
out1_tmp.trimestre = (TalendDate.getPartOfDate("MONTH", Var.maDate) / 3) + 1 ;
out1_tmp.saison = (TalendDate.getPartOfDate("MONTH", Var.maDate) + 1 >= 9) ? 
(TalendDate.getPartOfDate("YEAR", Var.maDate) + "_" + (TalendDate.getPartOfDate("YEAR", Var.maDate) + 1)) : 
((TalendDate.getPartOfDate("YEAR", Var.maDate) - 1) + "-" + TalendDate.getPartOfDate("YEAR", Var.maDate)) ;
out1 = out1_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(out1.full_date != null) {
pstmt_tDBOutput_1.setTimestamp(1, new java.sql.Timestamp(out1.full_date.getTime()));
} else {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.TIMESTAMP);
}

                    if(out1.date_id == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(2, out1.date_id);
}

                    if(out1.jour_nom == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, out1.jour_nom);
}

                    if(out1.mois_nom == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(4, out1.mois_nom);
}

                    if(out1.annee == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(5, out1.annee);
}

                    if(out1.trimestre == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(6, out1.trimestre);
}

                    if(out1.saison == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(7, out1.saison);
}


        		pstmt_tDBOutput_1.addBatch();
        		nb_line_tDBOutput_1++;
        		
    		 
    		  batchSizeCounter_tDBOutput_1++;
    		
            	//////////batch execute by batch size///////
            	class LimitBytesHelper_tDBOutput_1{
            		public int limitBytePart1(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
						
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
				
            	    	
                		System.err.println(e.getMessage());
                	
               			 }
    				return counter;
            	}
            	
            	public int limitBytePart2(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
                		
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					
            	    	
                        System.err.println(e.getMessage());
                	
                		}	
                	return counter;	
            	}
            }
    		if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
    		
    		            
            	    		insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1().limitBytePart1(insertedCount_tDBOutput_1,pstmt_tDBOutput_1);
            	    		rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;
            	    	
    			
			    batchSizeCounter_tDBOutput_1 = 0;
			}
    		

    	////////////commit every////////////
    			
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
    		            
            	    		insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1().limitBytePart1(insertedCount_tDBOutput_1,pstmt_tDBOutput_1);
            	    	
            	batchSizeCounter_tDBOutput_1 = 0;
            	}
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                }
                conn_tDBOutput_1.commit();
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                	rowsToCommitCount_tDBOutput_1 = 0;	
                }
                commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tRowGenerator_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_end ] stop
 */
	
	/**
	 * [tRowGenerator_1 end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

}
globalMap.put("tRowGenerator_1_NB_LINE",nb_line_tRowGenerator_1);

 

ok_Hash.put("tRowGenerator_1", true);
end_Hash.put("tRowGenerator_1", System.currentTimeMillis());




/**
 * [tRowGenerator_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



                try {
						int countSum_tDBOutput_1 = 0;
						if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {
							
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
									break;
								}
								countSum_tDBOutput_1 += countEach_tDBOutput_1;
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
						}
            	    	
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
            	    	
                		System.err.println(e.getMessage());
                	
            	}
        if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            }
            conn_tDBOutput_1.commit();
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            	rowsToCommitCount_tDBOutput_1 = 0;
            }
            commitCounter_tDBOutput_1 = 0;
        conn_tDBOutput_1 .close();
        resourceMap.put("finish_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRowGenerator_1 finally ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 1);
	}
	

public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBRow_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRow_1", false);
		start_Hash.put("tDBRow_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRow_1";

	
		int tos_count_tDBRow_1 = 0;
		

	java.sql.Connection conn_tDBRow_1 = null;
	String query_tDBRow_1 = "";
	boolean whetherReject_tDBRow_1 = false;
			String driverClass_tDBRow_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		    java.lang.Class jdbcclazz_tDBRow_1 = java.lang.Class.forName(driverClass_tDBRow_1);
		
			String port_tDBRow_1 = "1433";
		    String dbname_tDBRow_1 = "scout_DW" ;
		    		    
		    String url_tDBRow_1 = "jdbc:sqlserver://" + "localhost" ;
			
		    if (!"".equals(port_tDBRow_1)) {
		    	url_tDBRow_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBRow_1)) {
		   			    
		    	url_tDBRow_1 += ";databaseName=" + "scout_DW"; 
			
		    }
		    url_tDBRow_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		
					String dbUser_tDBRow_1 = "talend_user";
	        
            		
            		
            		 
	final String decryptedPassword_tDBRow_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:cHm7KAlcuJ8OpAnOV6vN0Gu6CEznjuy6o0Ogm5lZP7SJyfjJu6M=");
        		   	
        	        String dbPwd_tDBRow_1 = decryptedPassword_tDBRow_1;
	        
					
			conn_tDBRow_1 = java.sql.DriverManager.getConnection(url_tDBRow_1,dbUser_tDBRow_1,dbPwd_tDBRow_1);
		
        resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
					if(conn_tDBRow_1.getAutoCommit()) {
						
				conn_tDBRow_1.setAutoCommit(false);
			
					}        
					int commitEvery_tDBRow_1 = 10000;
					int commitCounter_tDBRow_1 = 0;
				
        java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
        resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

 



/**
 * [tDBRow_1 begin ] stop
 */
	
	/**
	 * [tDBRow_1 main ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

query_tDBRow_1 = "DELETE FROM [dbo].[dim_date]";
whetherReject_tDBRow_1 = false;
globalMap.put("tDBRow_1_QUERY",query_tDBRow_1);
try {
		stmt_tDBRow_1.execute(query_tDBRow_1);
		
	} catch (java.lang.Exception e) {
		whetherReject_tDBRow_1 = true;
		
				System.err.print(e.getMessage());
				globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());
				
	}
	
		commitCounter_tDBRow_1++;
		if(commitEvery_tDBRow_1 <= commitCounter_tDBRow_1) {
			
			conn_tDBRow_1.commit();
			
			commitCounter_tDBRow_1=0;
		}
		

 


	tos_count_tDBRow_1++;

/**
 * [tDBRow_1 main ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

 



/**
 * [tDBRow_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRow_1 end ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

	
        stmt_tDBRow_1.close();
        resourceMap.remove("stmt_tDBRow_1");
    resourceMap.put("statementClosed_tDBRow_1", true);
		if(commitEvery_tDBRow_1>commitCounter_tDBRow_1){

			
			conn_tDBRow_1.commit();
			
	
			commitCounter_tDBRow_1=0;
	
		}
			conn_tDBRow_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
    resourceMap.put("finish_tDBRow_1", true);
 

ok_Hash.put("tDBRow_1", true);
end_Hash.put("tDBRow_1", System.currentTimeMillis());




/**
 * [tDBRow_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRow_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRow_1";

	

try {
    if (resourceMap.get("statementClosed_tDBRow_1") == null) {
            java.sql.Statement stmtToClose_tDBRow_1 = null;
            if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
                stmtToClose_tDBRow_1.close();
            }
    }
} finally {
        if(resourceMap.get("finish_tDBRow_1") == null){
            java.sql.Connection ctn_tDBRow_1 = null;
            if((ctn_tDBRow_1 = (java.sql.Connection)resourceMap.get("conn_tDBRow_1")) != null){
                try {
                    ctn_tDBRow_1.close();
                } catch (java.sql.SQLException sqlEx_tDBRow_1) {
                    String errorMessage_tDBRow_1 = "failed to close the connection in tDBRow_1 :" + sqlEx_tDBRow_1.getMessage();
                    System.err.println(errorMessage_tDBRow_1);
                }
            }
        }
    }
 



/**
 * [tDBRow_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final dim_date_methode2 dim_date_methode2Class = new dim_date_methode2();

        int exitCode = dim_date_methode2Class.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = dim_date_methode2.class.getClassLoader().getResourceAsStream("projet_pi_bi/dim_date_methode2_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = dim_date_methode2.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRowGenerator_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRowGenerator_1) {
globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", -1);

e_tRowGenerator_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : dim_date_methode2");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     69267 characters generated by Talend Open Studio for Data Integration 
 *     on the 28 février 2026 à 18:02:37 WAT
 ************************************************************************************************/