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


package projet_pi_bi.dim_membre_methode2_0_1;

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
 * Job: dim_membre_methode2 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class dim_membre_methode2 implements TalendJob {

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
	private final String jobName = "dim_membre_methode2";
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
				dim_membre_methode2.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(dim_membre_methode2.this, new Object[] { e , currentComponent, globalMap});
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

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class add_memberStruct implements routines.system.IPersistableRow<add_memberStruct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String membre_rank;

				public String getMembre_rank () {
					return this.membre_rank;
				}
				
			    public Integer membre_code;

				public Integer getMembre_code () {
					return this.membre_code;
				}
				
			    public String training_level;

				public String getTraining_level () {
					return this.training_level;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public Integer unit_fk;

				public Integer getUnit_fk () {
					return this.unit_fk;
				}
				
			    public String membre_position;

				public String getMembre_position () {
					return this.membre_position;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
						this.unit_fk = readInteger(dis);
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
						this.unit_fk = readInteger(dis);
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// Integer
				
						writeInteger(this.unit_fk,dos);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// Integer
				
						writeInteger(this.unit_fk,dos);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("membre_rank="+membre_rank);
		sb.append(",membre_code="+String.valueOf(membre_code));
		sb.append(",training_level="+training_level);
		sb.append(",last_name="+last_name);
		sb.append(",first_name="+first_name);
		sb.append(",unit_fk="+String.valueOf(unit_fk));
		sb.append(",membre_position="+membre_position);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(add_memberStruct other) {

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

public static class update_memberStruct implements routines.system.IPersistableRow<update_memberStruct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String membre_rank;

				public String getMembre_rank () {
					return this.membre_rank;
				}
				
			    public Integer membre_code;

				public Integer getMembre_code () {
					return this.membre_code;
				}
				
			    public String training_level;

				public String getTraining_level () {
					return this.training_level;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public int unit_fk;

				public int getUnit_fk () {
					return this.unit_fk;
				}
				
			    public String membre_position;

				public String getMembre_position () {
					return this.membre_position;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
			        this.unit_fk = dis.readInt();
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
			        this.unit_fk = dis.readInt();
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// int
				
		            	dos.writeInt(this.unit_fk);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// int
				
		            	dos.writeInt(this.unit_fk);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("membre_rank="+membre_rank);
		sb.append(",membre_code="+String.valueOf(membre_code));
		sb.append(",training_level="+training_level);
		sb.append(",last_name="+last_name);
		sb.append(",first_name="+first_name);
		sb.append(",unit_fk="+String.valueOf(unit_fk));
		sb.append(",membre_position="+membre_position);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(update_memberStruct other) {

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

public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String membre_rank;

				public String getMembre_rank () {
					return this.membre_rank;
				}
				
			    public Integer membre_code;

				public Integer getMembre_code () {
					return this.membre_code;
				}
				
			    public String training_level;

				public String getTraining_level () {
					return this.training_level;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public Integer unit_fk;

				public Integer getUnit_fk () {
					return this.unit_fk;
				}
				
			    public String membre_position;

				public String getMembre_position () {
					return this.membre_position;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
						this.unit_fk = readInteger(dis);
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
						this.unit_fk = readInteger(dis);
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// Integer
				
						writeInteger(this.unit_fk,dos);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// Integer
				
						writeInteger(this.unit_fk,dos);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("membre_rank="+membre_rank);
		sb.append(",membre_code="+String.valueOf(membre_code));
		sb.append(",training_level="+training_level);
		sb.append(",last_name="+last_name);
		sb.append(",first_name="+first_name);
		sb.append(",unit_fk="+String.valueOf(unit_fk));
		sb.append(",membre_position="+membre_position);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

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

public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String membre_rank;

				public String getMembre_rank () {
					return this.membre_rank;
				}
				
			    public Integer membre_code;

				public Integer getMembre_code () {
					return this.membre_code;
				}
				
			    public String training_level;

				public String getTraining_level () {
					return this.training_level;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public int unit_fk;

				public int getUnit_fk () {
					return this.unit_fk;
				}
				
			    public String membre_position;

				public String getMembre_position () {
					return this.membre_position;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
			        this.unit_fk = dis.readInt();
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.membre_rank = readString(dis);
					
						this.membre_code = readInteger(dis);
					
					this.training_level = readString(dis);
					
					this.last_name = readString(dis);
					
					this.first_name = readString(dis);
					
			        this.unit_fk = dis.readInt();
					
					this.membre_position = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// int
				
		            	dos.writeInt(this.unit_fk);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.membre_rank,dos);
					
					// Integer
				
						writeInteger(this.membre_code,dos);
					
					// String
				
						writeString(this.training_level,dos);
					
					// String
				
						writeString(this.last_name,dos);
					
					// String
				
						writeString(this.first_name,dos);
					
					// int
				
		            	dos.writeInt(this.unit_fk);
					
					// String
				
						writeString(this.membre_position,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("membre_rank="+membre_rank);
		sb.append(",membre_code="+String.valueOf(membre_code));
		sb.append(",training_level="+training_level);
		sb.append(",last_name="+last_name);
		sb.append(",first_name="+first_name);
		sb.append(",unit_fk="+String.valueOf(unit_fk));
		sb.append(",membre_position="+membre_position);
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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String Code_unite;

				public String getCode_unite () {
					return this.Code_unite;
				}
				
			    public Integer Column1;

				public Integer getColumn1 () {
					return this.Column1;
				}
				
			    public String Column2;

				public String getColumn2 () {
					return this.Column2;
				}
				
			    public String Column3;

				public String getColumn3 () {
					return this.Column3;
				}
				
			    public String Column4;

				public String getColumn4 () {
					return this.Column4;
				}
				
			    public String Column5;

				public String getColumn5 () {
					return this.Column5;
				}
				
			    public String Column6;

				public String getColumn6 () {
					return this.Column6;
				}
				
			    public String Column7;

				public String getColumn7 () {
					return this.Column7;
				}
				
			    public String Column8;

				public String getColumn8 () {
					return this.Column8;
				}
				
			    public String Column9;

				public String getColumn9 () {
					return this.Column9;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
						this.Column1 = readInteger(dis);
					
					this.Column2 = readString(dis);
					
					this.Column3 = readString(dis);
					
					this.Column4 = readString(dis);
					
					this.Column5 = readString(dis);
					
					this.Column6 = readString(dis);
					
					this.Column7 = readString(dis);
					
					this.Column8 = readString(dis);
					
					this.Column9 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
						this.Column1 = readInteger(dis);
					
					this.Column2 = readString(dis);
					
					this.Column3 = readString(dis);
					
					this.Column4 = readString(dis);
					
					this.Column5 = readString(dis);
					
					this.Column6 = readString(dis);
					
					this.Column7 = readString(dis);
					
					this.Column8 = readString(dis);
					
					this.Column9 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// Integer
				
						writeInteger(this.Column1,dos);
					
					// String
				
						writeString(this.Column2,dos);
					
					// String
				
						writeString(this.Column3,dos);
					
					// String
				
						writeString(this.Column4,dos);
					
					// String
				
						writeString(this.Column5,dos);
					
					// String
				
						writeString(this.Column6,dos);
					
					// String
				
						writeString(this.Column7,dos);
					
					// String
				
						writeString(this.Column8,dos);
					
					// String
				
						writeString(this.Column9,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// Integer
				
						writeInteger(this.Column1,dos);
					
					// String
				
						writeString(this.Column2,dos);
					
					// String
				
						writeString(this.Column3,dos);
					
					// String
				
						writeString(this.Column4,dos);
					
					// String
				
						writeString(this.Column5,dos);
					
					// String
				
						writeString(this.Column6,dos);
					
					// String
				
						writeString(this.Column7,dos);
					
					// String
				
						writeString(this.Column8,dos);
					
					// String
				
						writeString(this.Column9,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_unite="+Code_unite);
		sb.append(",Column1="+String.valueOf(Column1));
		sb.append(",Column2="+Column2);
		sb.append(",Column3="+Column3);
		sb.append(",Column4="+Column4);
		sb.append(",Column5="+Column5);
		sb.append(",Column6="+Column6);
		sb.append(",Column7="+Column7);
		sb.append(",Column8="+Column8);
		sb.append(",Column9="+Column9);
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

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];

	
			    public String Code_unite;

				public String getCode_unite () {
					return this.Code_unite;
				}
				
			    public Integer Column1;

				public Integer getColumn1 () {
					return this.Column1;
				}
				
			    public String Column2;

				public String getColumn2 () {
					return this.Column2;
				}
				
			    public String Column3;

				public String getColumn3 () {
					return this.Column3;
				}
				
			    public String Column4;

				public String getColumn4 () {
					return this.Column4;
				}
				
			    public String Column5;

				public String getColumn5 () {
					return this.Column5;
				}
				
			    public String Column6;

				public String getColumn6 () {
					return this.Column6;
				}
				
			    public String Column7;

				public String getColumn7 () {
					return this.Column7;
				}
				
			    public String Column8;

				public String getColumn8 () {
					return this.Column8;
				}
				
			    public String Column9;

				public String getColumn9 () {
					return this.Column9;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
						this.Column1 = readInteger(dis);
					
					this.Column2 = readString(dis);
					
					this.Column3 = readString(dis);
					
					this.Column4 = readString(dis);
					
					this.Column5 = readString(dis);
					
					this.Column6 = readString(dis);
					
					this.Column7 = readString(dis);
					
					this.Column8 = readString(dis);
					
					this.Column9 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
						this.Column1 = readInteger(dis);
					
					this.Column2 = readString(dis);
					
					this.Column3 = readString(dis);
					
					this.Column4 = readString(dis);
					
					this.Column5 = readString(dis);
					
					this.Column6 = readString(dis);
					
					this.Column7 = readString(dis);
					
					this.Column8 = readString(dis);
					
					this.Column9 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// Integer
				
						writeInteger(this.Column1,dos);
					
					// String
				
						writeString(this.Column2,dos);
					
					// String
				
						writeString(this.Column3,dos);
					
					// String
				
						writeString(this.Column4,dos);
					
					// String
				
						writeString(this.Column5,dos);
					
					// String
				
						writeString(this.Column6,dos);
					
					// String
				
						writeString(this.Column7,dos);
					
					// String
				
						writeString(this.Column8,dos);
					
					// String
				
						writeString(this.Column9,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// Integer
				
						writeInteger(this.Column1,dos);
					
					// String
				
						writeString(this.Column2,dos);
					
					// String
				
						writeString(this.Column3,dos);
					
					// String
				
						writeString(this.Column4,dos);
					
					// String
				
						writeString(this.Column5,dos);
					
					// String
				
						writeString(this.Column6,dos);
					
					// String
				
						writeString(this.Column7,dos);
					
					// String
				
						writeString(this.Column8,dos);
					
					// String
				
						writeString(this.Column9,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_unite="+Code_unite);
		sb.append(",Column1="+String.valueOf(Column1));
		sb.append(",Column2="+Column2);
		sb.append(",Column3="+Column3);
		sb.append(",Column4="+Column4);
		sb.append(",Column5="+Column5);
		sb.append(",Column6="+Column6);
		sb.append(",Column7="+Column7);
		sb.append(",Column8="+Column8);
		sb.append(",Column9="+Column9);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

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
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();
row3Struct row3 = new row3Struct();
add_memberStruct add_member = new add_memberStruct();
update_memberStruct update_member = new update_memberStruct();







	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"add_member");
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:vFZgtG/rEEHeG2mUHvTZ4OlAW0gVp1eJhk+/bxpPHifBnxxpaoc=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "dim_membre";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "dim_membre";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([membre_rank] NVARCHAR(100)  ,[membre_code] INT ,[training_level] NVARCHAR(100)  ,[last_name] NVARCHAR(100)  ,[first_name] VARCHAR(100)  ,[unit_fk] INT IDENTITY(100,0)  ,[membre_position] VARCHAR(100)   not null )");
                                    }
                                }
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([membre_rank],[membre_code],[training_level],[last_name],[first_name],[unit_fk],[membre_position]) VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"update_member");
					}
				
		int tos_count_tDBOutput_2 = 0;
		



int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;
String dbschema_tDBOutput_2 = null;
String tableName_tDBOutput_2 = null;
boolean whetherReject_tDBOutput_2 = false;

java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
long year1_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd","0001-01-01").getTime();
long year2_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd","1753-01-01").getTime();
long year10000_tDBOutput_2 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss","9999-12-31 24:00:00").getTime();
long date_tDBOutput_2;

java.util.Calendar calendar_datetimeoffset_tDBOutput_2 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));


        int updateKeyCount_tDBOutput_2 = 1;
        if(updateKeyCount_tDBOutput_2 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_2 == 7 && true) {        
                throw new RuntimeException("For update, every Schema column can not be a key");
        }

	
java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;
    dbschema_tDBOutput_2 = "dbo";
    String driverClass_tDBOutput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
    java.lang.Class.forName(driverClass_tDBOutput_2);
    String port_tDBOutput_2 = "1433";
    String dbname_tDBOutput_2 = "scout_DW" ;
    String url_tDBOutput_2 = "jdbc:sqlserver://" + "localhost" ; 
    if (!"".equals(port_tDBOutput_2)) {
    	url_tDBOutput_2 += ":" + "1433";
    }
    if (!"".equals(dbname_tDBOutput_2)) {		    
		    	url_tDBOutput_2 += ";databaseName=" + "scout_DW"; 
	
    }
    url_tDBOutput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
    dbUser_tDBOutput_2 = "talend_user";

 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:XEY/xomKUk5EiVfDRzAAs5h1i7Obid4hyyjqWbwqrVmQFpZjDfI=");

    String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;	
    conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2,dbUser_tDBOutput_2,dbPwd_tDBOutput_2);
	
		resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
	
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;

   int batchSize_tDBOutput_2 = 10000;
   int batchSizeCounter_tDBOutput_2=0;

if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
    tableName_tDBOutput_2 = "dim_membre";
} else {
    tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].[" + "dim_membre";
}
	int count_tDBOutput_2=0;

        String update_tDBOutput_2 = "UPDATE [" + tableName_tDBOutput_2 + "] SET [membre_rank] = ?,[training_level] = ?,[last_name] = ?,[first_name] = ?,[unit_fk] = ?,[membre_position] = ? WHERE [membre_code] = ?";
        java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
        resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
add_memberStruct add_member_tmp = new add_memberStruct();
update_memberStruct update_member_tmp = new update_memberStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_1", false);
		start_Hash.put("tUniqRow_1", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tUniqRow_1 = 0;
		

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					Integer membre_code;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.membre_code == null) ? 0 : this.membre_code.hashCode());
								
		    		this.hashCode = result;
		    		this.hashCodeDirty = false;		
				}
				return this.hashCode;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null) return false;
				if (getClass() != obj.getClass()) return false;
				final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;
				
									if (this.membre_code == null) {
										if (other.membre_code != null) 
											return false;
								
									} else if (!this.membre_code.equals(other.membre_code))
								 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_1 = 0;
int nb_duplicates_tUniqRow_1 = 0;
KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>(); 

 



/**
 * [tUniqRow_1 begin ] stop
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
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
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
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_1  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1); 
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "talend_user";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:QHkqqLxOqReH9CrAPwS07NpPcNRVSmAjdBNxs8BtIZYlb7OBumw=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
		    String port_tDBInput_1 = "1433";
		    String dbname_tDBInput_1 = "youth_leadership_and_outdoor_education" ;		    
		    String url_tDBInput_1 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_1)) {
		    	url_tDBInput_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_1)) {		    
		    	url_tDBInput_1 += ";databaseName=" + "youth_leadership_and_outdoor_education"; 
		    }
		    url_tDBInput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_1 = "dbo";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "select dbo.list_sa.Code_unite,dbo.list_sa.\"المعرف\",dbo.list_sa.\"الإسم\",dbo.list_sa.\"اللقب\",dbo.list_sa.\"ب.ت.و\","
+"dbo.list_sa.\"الهاتف\",dbo.list_sa.\"تاريخ الولادة\",dbo.list_sa.\"المستوى التدريبي\",dbo.list_sa.\"الرتبة\",dbo.list_sa"
+".\"إطار الوحدة||مشارك\" \nfrom dbo.list_sa";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.Code_unite = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Code_unite = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Code_unite = tmpContent_tDBInput_1;
                }
            } else {
                row1.Code_unite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.Column1 = null;
							} else {
		                          
            row1.Column1 = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    row1.Column1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.Column2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.Column3 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column3 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column3 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column3 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.Column4 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column4 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column4 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column4 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.Column5 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column5 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column5 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column5 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.Column6 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column6 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column6 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column6 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.Column7 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column7 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column7 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column7 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.Column8 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column8 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column8 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column8 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.Column9 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Column9 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Column9 = tmpContent_tDBInput_1;
                }
            } else {
                row1.Column9 = null;
            }
		                    }
					





 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
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
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.unit_code = row1.Code_unite ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.unit_code = '" + row2HashKey.unit_code + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'out1'
out1_tmp.membre_rank = row1.Column8 ;
out1_tmp.membre_code = row1.Column1 ;
out1_tmp.training_level = row1.Column7 ;
out1_tmp.last_name = row1.Column2 ;
out1_tmp.first_name = row1.Column3 ;
out1_tmp.unit_fk = row2.unit_id ;
out1_tmp.membre_position = row1.Column9 ;
out1 = out1_tmp;
}  // closing inner join bracket (2)
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
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					
row3 = null;			
finder_tUniqRow_1.membre_code = out1.membre_code;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.membre_code = out1.membre_code;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row3 == null){ 
	
	row3 = new row3Struct();
}row3.membre_rank = out1.membre_rank;			row3.membre_code = out1.membre_code;			row3.training_level = out1.training_level;			row3.last_name = out1.last_name;			row3.first_name = out1.first_name;			row3.unit_fk = out1.unit_fk;			row3.membre_position = out1.membre_position;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

/**
 * [tUniqRow_1 main ] stop
 */
	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row4HashKey.membre_code = row3.membre_code ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.membre_code = '" + row4HashKey.membre_code + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

add_member = null;
update_member = null;


// # Output table : 'add_member'
// # Filter conditions 
if( 

row4.membre_code == null

 ) {
add_member_tmp.membre_rank = row3.membre_rank ;
add_member_tmp.membre_code = row3.membre_code ;
add_member_tmp.training_level = row3.training_level ;
add_member_tmp.last_name = row3.last_name ;
add_member_tmp.first_name = row3.first_name ;
add_member_tmp.unit_fk = row3.unit_fk ;
add_member_tmp.membre_position = row3.membre_position ;
add_member = add_member_tmp;
} // closing filter/reject

// # Output table : 'update_member'
// # Filter conditions 
if( 

row4.membre_code != null

 ) {
update_member_tmp.membre_rank = row3.membre_rank ;
update_member_tmp.membre_code = row3.membre_code ;
update_member_tmp.training_level = row3.training_level ;
update_member_tmp.last_name = row3.last_name ;
update_member_tmp.first_name = row3.first_name ;
update_member_tmp.unit_fk = row3.unit_fk ;
update_member_tmp.membre_position = row3.membre_position ;
update_member = update_member_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "add_member"
if(add_member != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"add_member"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(add_member.membre_rank == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(1, add_member.membre_rank);
} else {
pstmt_tDBOutput_1.setString(1, add_member.membre_rank);
}
}

                    if(add_member.membre_code == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(2, add_member.membre_code);
}

                    if(add_member.training_level == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(3, add_member.training_level);
} else {
pstmt_tDBOutput_1.setString(3, add_member.training_level);
}
}

                    if(add_member.last_name == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(4, add_member.last_name);
} else {
pstmt_tDBOutput_1.setString(4, add_member.last_name);
}
}

                    if(add_member.first_name == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(5, add_member.first_name);
}

                    if(add_member.unit_fk == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(6, add_member.unit_fk);
}

                    if(add_member.membre_position == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(7, add_member.membre_position);
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

} // End of branch "add_member"




// Start of branch "update_member"
if(update_member != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"update_member"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(update_member.membre_rank == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(1, update_member.membre_rank);
} else {
pstmt_tDBOutput_2.setString(1, update_member.membre_rank);
}
}

                    if(update_member.training_level == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(2, update_member.training_level);
} else {
pstmt_tDBOutput_2.setString(2, update_member.training_level);
}
}

                    if(update_member.last_name == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(3, update_member.last_name);
} else {
pstmt_tDBOutput_2.setString(3, update_member.last_name);
}
}

                    if(update_member.first_name == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(4, update_member.first_name);
} else {
pstmt_tDBOutput_2.setString(4, update_member.first_name);
}
}

                    pstmt_tDBOutput_2.setInt(5, update_member.unit_fk);

                    if(update_member.membre_position == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(6, update_member.membre_position);
} else {
pstmt_tDBOutput_2.setString(6, update_member.membre_position);
}
}


                    pstmt_tDBOutput_2.setInt(7 + count_tDBOutput_2, update_member.membre_code);


    		pstmt_tDBOutput_2.addBatch();
    		nb_line_tDBOutput_2++;
    		
    		
    		batchSizeCounter_tDBOutput_2++;
    		
            	//////////batch execute by batch size///////
            	class LimitBytesHelper_tDBOutput_2{
            		public int limitBytePart1(int counter,java.sql.PreparedStatement pstmt_tDBOutput_2) throws Exception {
                try {
						
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							if(countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
								break;
							}
							counter += countEach_tDBOutput_2;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_2 = 0;
					for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
				
            	    	
                		System.err.println(e.getMessage());
                	
               			 }
    				return counter;
            	}
            	
            	public int limitBytePart2(int counter,java.sql.PreparedStatement pstmt_tDBOutput_2) throws Exception {
                try {
                		
						for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
							if(countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
								break;
							}
							counter += countEach_tDBOutput_2;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                	
                	
					for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					
            	    	
                        System.err.println(e.getMessage());
                	
                		}	
                	return counter;	
            	}
            }
    		if ((batchSize_tDBOutput_2 > 0) && (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {
    		
    		            
            	    		updatedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2().limitBytePart1(updatedCount_tDBOutput_2,pstmt_tDBOutput_2);
            	    		rowsToCommitCount_tDBOutput_2 = updatedCount_tDBOutput_2;
            	    	
    			
			    batchSizeCounter_tDBOutput_2 = 0;
			}
    		

    	////////////commit every////////////
    			
    		    commitCounter_tDBOutput_2++;
                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
                if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {
    		            
            	    		updatedCount_tDBOutput_2 = new LimitBytesHelper_tDBOutput_2().limitBytePart1(updatedCount_tDBOutput_2,pstmt_tDBOutput_2);
            	    	
            	batchSizeCounter_tDBOutput_2 = 0;
            	}
                if(rowsToCommitCount_tDBOutput_2 != 0){
                	
                }
                conn_tDBOutput_2.commit();
                if(rowsToCommitCount_tDBOutput_2 != 0){
                	
                	rowsToCommitCount_tDBOutput_2 = 0;	
                }
                commitCounter_tDBOutput_2=0;
                }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "update_member"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "row3"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
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
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);

 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
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
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




/**
 * [tUniqRow_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"add_member");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */




	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



                try {
						int countSum_tDBOutput_2 = 0;
						if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {
							
							for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
								if(countEach_tDBOutput_2 == -2 || countEach_tDBOutput_2 == -3) {
									break;
								}
								countSum_tDBOutput_2 += countEach_tDBOutput_2;
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
							
						}
            	    	
            	    		updatedCount_tDBOutput_2 += countSum_tDBOutput_2;
            	    	
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_2 = 0;
					for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
					
            	    		updatedCount_tDBOutput_2 += countSum_tDBOutput_2;
            	    	
                		System.err.println(e.getMessage());
                	
            	}
        if(pstmt_tDBOutput_2 != null) {
			
				pstmt_tDBOutput_2.close();
				resourceMap.remove("pstmt_tDBOutput_2");
			
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);
            if(rowsToCommitCount_tDBOutput_2 != 0){
            	
            }
            conn_tDBOutput_2.commit();
            if(rowsToCommitCount_tDBOutput_2 != 0){
            	
            	rowsToCommitCount_tDBOutput_2 = 0;
            }
            commitCounter_tDBOutput_2 = 0;
        conn_tDBOutput_2 .close();
        resourceMap.put("finish_tDBOutput_2", true);

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"update_member");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */












				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
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




	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                    ctn_tDBOutput_2.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int unit_id;

				public int getUnit_id () {
					return this.unit_id;
				}
				
			    public String unite_name;

				public String getUnite_name () {
					return this.unite_name;
				}
				
			    public String unit_code;

				public String getUnit_code () {
					return this.unit_code;
				}
				
			    public String age_category;

				public String getAge_category () {
					return this.age_category;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.unit_code == null) ? 0 : this.unit_code.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.unit_code == null) {
							if (other.unit_code != null)
								return false;
						
						} else if (!this.unit_code.equals(other.unit_code))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.unit_id = this.unit_id;
	            other.unite_name = this.unite_name;
	            other.unit_code = this.unit_code;
	            other.age_category = this.age_category;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.unit_code = this.unit_code;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_membre_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_membre_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_membre_methode2, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.unit_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
					this.unit_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.unit_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.unit_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.unit_id = dis.readInt();
					
						this.unite_name = readString(dis,ois);
					
						this.age_category = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.unit_id = objectIn.readInt();
					
						this.unite_name = readString(dis,objectIn);
					
						this.age_category = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.unit_id);
					
						writeString(this.unite_name, dos, oos);
					
						writeString(this.age_category, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.unit_id);
					
						writeString(this.unite_name, dos, objectOut);
					
						writeString(this.age_category, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("unit_id="+String.valueOf(unit_id));
		sb.append(",unite_name="+unite_name);
		sb.append(",unit_code="+unit_code);
		sb.append(",age_category="+age_category);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.unit_code, other.unit_code);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_2  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2); 
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "talend_user";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:QaFci/54PzShqnXSIl/cGzwFb4L+FEB/FGOVfChTMhAxh3g5NYM=");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
		    String port_tDBInput_2 = "1433";
		    String dbname_tDBInput_2 = "scout_DW" ;		    
		    String url_tDBInput_2 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_2)) {
		    	url_tDBInput_2 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_2)) {		    
		    	url_tDBInput_2 += ";databaseName=" + "scout_DW"; 
		    }
		    url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_2 = "dbo";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "select dbo.dim_unite.unit_id,dbo.dim_unite.unite_name,dbo.dim_unite.unit_code,dbo.dim_unite.age_category \nfrom scout_DW"
+".dbo.dim_unite";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row2.unit_id = 0;
							} else {
		                          
            row2.unit_id = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.unite_name = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.unite_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.unite_name = tmpContent_tDBInput_2;
                }
            } else {
                row2.unite_name = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.unit_code = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.unit_code = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.unit_code = tmpContent_tDBInput_2;
                }
            } else {
                row2.unit_code = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.age_category = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.age_category = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.age_category = tmpContent_tDBInput_2;
                }
            } else {
                row2.age_category = null;
            }
		                    }
					





 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.unit_id = row2.unit_id;
				
				row2_HashRow.unite_name = row2.unite_name;
				
				row2_HashRow.unit_code = row2.unit_code;
				
				row2_HashRow.age_category = row2.age_category;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);

 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_membre_methode2 = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String membre_rank;

				public String getMembre_rank () {
					return this.membre_rank;
				}
				
			    public Integer membre_code;

				public Integer getMembre_code () {
					return this.membre_code;
				}
				
			    public String training_level;

				public String getTraining_level () {
					return this.training_level;
				}
				
			    public String last_name;

				public String getLast_name () {
					return this.last_name;
				}
				
			    public String first_name;

				public String getFirst_name () {
					return this.first_name;
				}
				
			    public Integer unit_fk;

				public Integer getUnit_fk () {
					return this.unit_fk;
				}
				
			    public String membre_position;

				public String getMembre_position () {
					return this.membre_position;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.membre_code == null) ? 0 : this.membre_code.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row4Struct other = (row4Struct) obj;
		
						if (this.membre_code == null) {
							if (other.membre_code != null)
								return false;
						
						} else if (!this.membre_code.equals(other.membre_code))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.membre_rank = this.membre_rank;
	            other.membre_code = this.membre_code;
	            other.training_level = this.training_level;
	            other.last_name = this.last_name;
	            other.first_name = this.first_name;
	            other.unit_fk = this.unit_fk;
	            other.membre_position = this.membre_position;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.membre_code = this.membre_code;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
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
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
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
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
						this.membre_code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_membre_methode2) {

        	try {

        		int length = 0;
		
						this.membre_code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.membre_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.membre_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.membre_rank = readString(dis,ois);
					
						this.training_level = readString(dis,ois);
					
						this.last_name = readString(dis,ois);
					
						this.first_name = readString(dis,ois);
					
						this.unit_fk = readInteger(dis,ois);
					
						this.membre_position = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.membre_rank = readString(dis,objectIn);
					
						this.training_level = readString(dis,objectIn);
					
						this.last_name = readString(dis,objectIn);
					
						this.first_name = readString(dis,objectIn);
					
						this.unit_fk = readInteger(dis,objectIn);
					
						this.membre_position = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.membre_rank, dos, oos);
					
						writeString(this.training_level, dos, oos);
					
						writeString(this.last_name, dos, oos);
					
						writeString(this.first_name, dos, oos);
					
					writeInteger(this.unit_fk, dos, oos);
					
						writeString(this.membre_position, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.membre_rank, dos, objectOut);
					
						writeString(this.training_level, dos, objectOut);
					
						writeString(this.last_name, dos, objectOut);
					
						writeString(this.first_name, dos, objectOut);
					
					writeInteger(this.unit_fk, dos, objectOut);
					
						writeString(this.membre_position, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("membre_rank="+membre_rank);
		sb.append(",membre_code="+String.valueOf(membre_code));
		sb.append(",training_level="+training_level);
		sb.append(",last_name="+last_name);
		sb.append(",first_name="+first_name);
		sb.append(",unit_fk="+String.valueOf(unit_fk));
		sb.append(",membre_position="+membre_position);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.membre_code, other.membre_code);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

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



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_2 - inputs:(row3,row4) outputs:(add_member,update_member)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_3  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3); 
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "talend_user";
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lXeICgnvHWRFzs/0Y+r5O4MQExAYGRX1iZNMwfzEqsW5BhtX3f4=");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
		    String port_tDBInput_3 = "1433";
		    String dbname_tDBInput_3 = "scout_DW" ;		    
		    String url_tDBInput_3 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_3)) {
		    	url_tDBInput_3 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_3)) {		    
		    	url_tDBInput_3 += ";databaseName=" + "scout_DW"; 
		    }
		    url_tDBInput_3 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_3 = "dbo";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "select dbo.dim_membre.membre_rank,dbo.dim_membre.membre_code,dbo.dim_membre.training_level,dbo.dim_membre.last_name,dbo"
+".dim_membre.first_name,dbo.dim_membre.unit_fk,dbo.dim_membre.membre_position \nfrom scout_DW.dbo.dim_membre";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row4.membre_rank = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(1);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.membre_rank = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.membre_rank = tmpContent_tDBInput_3;
                }
            } else {
                row4.membre_rank = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row4.membre_code = null;
							} else {
		                          
            row4.membre_code = rs_tDBInput_3.getInt(2);
            if(rs_tDBInput_3.wasNull()){
                    row4.membre_code = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row4.training_level = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.training_level = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.training_level = tmpContent_tDBInput_3;
                }
            } else {
                row4.training_level = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row4.last_name = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.last_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.last_name = tmpContent_tDBInput_3;
                }
            } else {
                row4.last_name = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row4.first_name = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.first_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.first_name = tmpContent_tDBInput_3;
                }
            } else {
                row4.first_name = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row4.unit_fk = null;
							} else {
		                          
            row4.unit_fk = rs_tDBInput_3.getInt(6);
            if(rs_tDBInput_3.wasNull()){
                    row4.unit_fk = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row4.membre_position = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.membre_position = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row4.membre_position = tmpContent_tDBInput_3;
                }
            } else {
                row4.membre_position = null;
            }
		                    }
					





 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.membre_rank = row4.membre_rank;
				
				row4_HashRow.membre_code = row4.membre_code;
				
				row4_HashRow.training_level = row4.training_level;
				
				row4_HashRow.last_name = row4.last_name;
				
				row4_HashRow.first_name = row4.first_name;
				
				row4_HashRow.unit_fk = row4.unit_fk;
				
				row4_HashRow.membre_position = row4.membre_position;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
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
        final dim_membre_methode2 dim_membre_methode2Class = new dim_membre_methode2();

        int exitCode = dim_membre_methode2Class.runJobInTOS(args);

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
            java.io.InputStream inContext = dim_membre_methode2.class.getClassLoader().getResourceAsStream("projet_pi_bi/dim_membre_methode2_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = dim_membre_methode2.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : dim_membre_methode2");
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
 *     183767 characters generated by Talend Open Studio for Data Integration 
 *     on the 28 février 2026 à 18:02:40 WAT
 ************************************************************************************************/