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


package projet_pi_bi.dim_location_methode2_0_1;

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
 * Job: dim_location_methode2 Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class dim_location_methode2 implements TalendJob {

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
	private final String jobName = "dim_location_methode2";
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
				dim_location_methode2.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(dim_location_methode2.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tUnite_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class add_locationStruct implements routines.system.IPersistableRow<add_locationStruct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(add_locationStruct other) {

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

public static class update_locationStruct implements routines.system.IPersistableRow<update_locationStruct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(update_locationStruct other) {

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

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

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

public static class out4Struct implements routines.system.IPersistableRow<out4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out4Struct other) {

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

public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				
			    public Integer Nombre;

				public Integer getNombre () {
					return this.Nombre;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
						this.Nombre = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
						this.Nombre = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
					// Integer
				
						writeInteger(this.Nombre,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
					// Integer
				
						writeInteger(this.Nombre,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
		sb.append(",Nombre="+String.valueOf(Nombre));
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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				
			    public Integer Nombre;

				public Integer getNombre () {
					return this.Nombre;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
						this.Nombre = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat = readString(dis);
					
						this.Nombre = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
					// Integer
				
						writeInteger(this.Nombre,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat,dos);
					
					// Integer
				
						writeInteger(this.Nombre,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
		sb.append(",Nombre="+String.valueOf(Nombre));
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

public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String location;

				public String getLocation () {
					return this.location;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.location = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.location = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.location,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.location,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",location="+location);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String event_id;

				public String getEvent_id () {
					return this.event_id;
				}
				
			    public String event;

				public String getEvent () {
					return this.event;
				}
				
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String location;

				public String getLocation () {
					return this.location;
				}
				
			    public String lat;

				public String getLat () {
					return this.lat;
				}
				
			    public String lon;

				public String getLon () {
					return this.lon;
				}
				
			    public Integer month;

				public Integer getMonth () {
					return this.month;
				}
				
			    public String season;

				public String getSeason () {
					return this.season;
				}
				
			    public Integer event_duration_days;

				public Integer getEvent_duration_days () {
					return this.event_duration_days;
				}
				
			    public String temp_max_mean;

				public String getTemp_max_mean () {
					return this.temp_max_mean;
				}
				
			    public String rain_total;

				public String getRain_total () {
					return this.rain_total;
				}
				
			    public String wind_max;

				public String getWind_max () {
					return this.wind_max;
				}
				
			    public Integer weather_score;

				public Integer getWeather_score () {
					return this.weather_score;
				}
				
			    public Boolean good_weather;

				public Boolean getGood_weather () {
					return this.good_weather;
				}
				
			    public String date_code;

				public String getDate_code () {
					return this.date_code;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.event_id = readString(dis);
					
					this.event = readString(dis);
					
					this.Code_lieu = readString(dis);
					
					this.location = readString(dis);
					
					this.lat = readString(dis);
					
					this.lon = readString(dis);
					
						this.month = readInteger(dis);
					
					this.season = readString(dis);
					
						this.event_duration_days = readInteger(dis);
					
					this.temp_max_mean = readString(dis);
					
					this.rain_total = readString(dis);
					
					this.wind_max = readString(dis);
					
						this.weather_score = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.good_weather = null;
           				} else {
           			    	this.good_weather = dis.readBoolean();
           				}
					
					this.date_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.event_id = readString(dis);
					
					this.event = readString(dis);
					
					this.Code_lieu = readString(dis);
					
					this.location = readString(dis);
					
					this.lat = readString(dis);
					
					this.lon = readString(dis);
					
						this.month = readInteger(dis);
					
					this.season = readString(dis);
					
						this.event_duration_days = readInteger(dis);
					
					this.temp_max_mean = readString(dis);
					
					this.rain_total = readString(dis);
					
					this.wind_max = readString(dis);
					
						this.weather_score = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.good_weather = null;
           				} else {
           			    	this.good_weather = dis.readBoolean();
           				}
					
					this.date_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.event_id,dos);
					
					// String
				
						writeString(this.event,dos);
					
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.location,dos);
					
					// String
				
						writeString(this.lat,dos);
					
					// String
				
						writeString(this.lon,dos);
					
					// Integer
				
						writeInteger(this.month,dos);
					
					// String
				
						writeString(this.season,dos);
					
					// Integer
				
						writeInteger(this.event_duration_days,dos);
					
					// String
				
						writeString(this.temp_max_mean,dos);
					
					// String
				
						writeString(this.rain_total,dos);
					
					// String
				
						writeString(this.wind_max,dos);
					
					// Integer
				
						writeInteger(this.weather_score,dos);
					
					// Boolean
				
						if(this.good_weather == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.good_weather);
		            	}
					
					// String
				
						writeString(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.event_id,dos);
					
					// String
				
						writeString(this.event,dos);
					
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.location,dos);
					
					// String
				
						writeString(this.lat,dos);
					
					// String
				
						writeString(this.lon,dos);
					
					// Integer
				
						writeInteger(this.month,dos);
					
					// String
				
						writeString(this.season,dos);
					
					// Integer
				
						writeInteger(this.event_duration_days,dos);
					
					// String
				
						writeString(this.temp_max_mean,dos);
					
					// String
				
						writeString(this.rain_total,dos);
					
					// String
				
						writeString(this.wind_max,dos);
					
					// Integer
				
						writeInteger(this.weather_score,dos);
					
					// Boolean
				
						if(this.good_weather == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.good_weather);
		            	}
					
					// String
				
						writeString(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("event_id="+event_id);
		sb.append(",event="+event);
		sb.append(",Code_lieu="+Code_lieu);
		sb.append(",location="+location);
		sb.append(",lat="+lat);
		sb.append(",lon="+lon);
		sb.append(",month="+String.valueOf(month));
		sb.append(",season="+season);
		sb.append(",event_duration_days="+String.valueOf(event_duration_days));
		sb.append(",temp_max_mean="+temp_max_mean);
		sb.append(",rain_total="+rain_total);
		sb.append(",wind_max="+wind_max);
		sb.append(",weather_score="+String.valueOf(weather_score));
		sb.append(",good_weather="+String.valueOf(good_weather));
		sb.append(",date_code="+date_code);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

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

public static class out3Struct implements routines.system.IPersistableRow<out3Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat_Sponsor;

				public String getGouvernorat_Sponsor () {
					return this.Gouvernorat_Sponsor;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat_Sponsor = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat_Sponsor = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat_Sponsor,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat_Sponsor,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat_Sponsor="+Gouvernorat_Sponsor);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out3Struct other) {

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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];

	
			    public Integer ID_Sponsor;

				public Integer getID_Sponsor () {
					return this.ID_Sponsor;
				}
				
			    public String Code_Sponsor;

				public String getCode_Sponsor () {
					return this.Code_Sponsor;
				}
				
			    public String Nom_Sponsor;

				public String getNom_Sponsor () {
					return this.Nom_Sponsor;
				}
				
			    public String Type_Sponsor;

				public String getType_Sponsor () {
					return this.Type_Sponsor;
				}
				
			    public String Secteur;

				public String getSecteur () {
					return this.Secteur;
				}
				
			    public String Theme_Sponsorship;

				public String getTheme_Sponsorship () {
					return this.Theme_Sponsorship;
				}
				
			    public String Unite;

				public String getUnite () {
					return this.Unite;
				}
				
			    public String Saison;

				public String getSaison () {
					return this.Saison;
				}
				
			    public String Date_Engagement;

				public String getDate_Engagement () {
					return this.Date_Engagement;
				}
				
			    public String Date_Reception;

				public String getDate_Reception () {
					return this.Date_Reception;
				}
				
			    public Integer Montant_Promis_TND;

				public Integer getMontant_Promis_TND () {
					return this.Montant_Promis_TND;
				}
				
			    public Integer Montant_Recu_TND;

				public Integer getMontant_Recu_TND () {
					return this.Montant_Recu_TND;
				}
				
			    public String Statut;

				public String getStatut () {
					return this.Statut;
				}
				
			    public String Affectation_Budgetaire;

				public String getAffectation_Budgetaire () {
					return this.Affectation_Budgetaire;
				}
				
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat_Sponsor;

				public String getGouvernorat_Sponsor () {
					return this.Gouvernorat_Sponsor;
				}
				
			    public String Notes;

				public String getNotes () {
					return this.Notes;
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
						this.ID_Sponsor = readInteger(dis);
					
					this.Code_Sponsor = readString(dis);
					
					this.Nom_Sponsor = readString(dis);
					
					this.Type_Sponsor = readString(dis);
					
					this.Secteur = readString(dis);
					
					this.Theme_Sponsorship = readString(dis);
					
					this.Unite = readString(dis);
					
					this.Saison = readString(dis);
					
					this.Date_Engagement = readString(dis);
					
					this.Date_Reception = readString(dis);
					
						this.Montant_Promis_TND = readInteger(dis);
					
						this.Montant_Recu_TND = readInteger(dis);
					
					this.Statut = readString(dis);
					
					this.Affectation_Budgetaire = readString(dis);
					
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat_Sponsor = readString(dis);
					
					this.Notes = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
						this.ID_Sponsor = readInteger(dis);
					
					this.Code_Sponsor = readString(dis);
					
					this.Nom_Sponsor = readString(dis);
					
					this.Type_Sponsor = readString(dis);
					
					this.Secteur = readString(dis);
					
					this.Theme_Sponsorship = readString(dis);
					
					this.Unite = readString(dis);
					
					this.Saison = readString(dis);
					
					this.Date_Engagement = readString(dis);
					
					this.Date_Reception = readString(dis);
					
						this.Montant_Promis_TND = readInteger(dis);
					
						this.Montant_Recu_TND = readInteger(dis);
					
					this.Statut = readString(dis);
					
					this.Affectation_Budgetaire = readString(dis);
					
					this.Code_lieu = readString(dis);
					
					this.Gouvernorat_Sponsor = readString(dis);
					
					this.Notes = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.ID_Sponsor,dos);
					
					// String
				
						writeString(this.Code_Sponsor,dos);
					
					// String
				
						writeString(this.Nom_Sponsor,dos);
					
					// String
				
						writeString(this.Type_Sponsor,dos);
					
					// String
				
						writeString(this.Secteur,dos);
					
					// String
				
						writeString(this.Theme_Sponsorship,dos);
					
					// String
				
						writeString(this.Unite,dos);
					
					// String
				
						writeString(this.Saison,dos);
					
					// String
				
						writeString(this.Date_Engagement,dos);
					
					// String
				
						writeString(this.Date_Reception,dos);
					
					// Integer
				
						writeInteger(this.Montant_Promis_TND,dos);
					
					// Integer
				
						writeInteger(this.Montant_Recu_TND,dos);
					
					// String
				
						writeString(this.Statut,dos);
					
					// String
				
						writeString(this.Affectation_Budgetaire,dos);
					
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat_Sponsor,dos);
					
					// String
				
						writeString(this.Notes,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.ID_Sponsor,dos);
					
					// String
				
						writeString(this.Code_Sponsor,dos);
					
					// String
				
						writeString(this.Nom_Sponsor,dos);
					
					// String
				
						writeString(this.Type_Sponsor,dos);
					
					// String
				
						writeString(this.Secteur,dos);
					
					// String
				
						writeString(this.Theme_Sponsorship,dos);
					
					// String
				
						writeString(this.Unite,dos);
					
					// String
				
						writeString(this.Saison,dos);
					
					// String
				
						writeString(this.Date_Engagement,dos);
					
					// String
				
						writeString(this.Date_Reception,dos);
					
					// Integer
				
						writeInteger(this.Montant_Promis_TND,dos);
					
					// Integer
				
						writeInteger(this.Montant_Recu_TND,dos);
					
					// String
				
						writeString(this.Statut,dos);
					
					// String
				
						writeString(this.Affectation_Budgetaire,dos);
					
					// String
				
						writeString(this.Code_lieu,dos);
					
					// String
				
						writeString(this.Gouvernorat_Sponsor,dos);
					
					// String
				
						writeString(this.Notes,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ID_Sponsor="+String.valueOf(ID_Sponsor));
		sb.append(",Code_Sponsor="+Code_Sponsor);
		sb.append(",Nom_Sponsor="+Nom_Sponsor);
		sb.append(",Type_Sponsor="+Type_Sponsor);
		sb.append(",Secteur="+Secteur);
		sb.append(",Theme_Sponsorship="+Theme_Sponsorship);
		sb.append(",Unite="+Unite);
		sb.append(",Saison="+Saison);
		sb.append(",Date_Engagement="+Date_Engagement);
		sb.append(",Date_Reception="+Date_Reception);
		sb.append(",Montant_Promis_TND="+String.valueOf(Montant_Promis_TND));
		sb.append(",Montant_Recu_TND="+String.valueOf(Montant_Recu_TND));
		sb.append(",Statut="+Statut);
		sb.append(",Affectation_Budgetaire="+Affectation_Budgetaire);
		sb.append(",Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat_Sponsor="+Gouvernorat_Sponsor);
		sb.append(",Notes="+Notes);
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


		tDBInput_4Process(globalMap);

		row1Struct row1 = new row1Struct();
out1Struct out1 = new out1Struct();

		row2Struct row2 = new row2Struct();
out2Struct out2 = new out2Struct();

		row3Struct row3 = new row3Struct();
out3Struct out3 = new out3Struct();

			row4Struct row4 = new row4Struct();
out4Struct out4 = new out4Struct();
row5Struct row5 = new row5Struct();
add_locationStruct add_location = new add_locationStruct();
update_locationStruct update_location = new update_locationStruct();







	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"add_location");
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:eg6J0BtHJrWb01bou5f+AfSAa7W/XEbKlvYtAfCz5ePkYzU+fVo=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "dim_location";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "dim_location";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([Code_lieu] VARCHAR(3)  ,[Gouvernorat] NVARCHAR(30)  ,primary key([Code_lieu]))");
                                    }
                                }
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([Code_lieu],[Gouvernorat]) VALUES (?,?)";
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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"update_location");
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
        } else if (updateKeyCount_tDBOutput_2 == 2 && true) {        
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

 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:4SLr7ZVs3JyINYPUeE8djdIZC5Pu8wd6TBRLfRIdTExugKjGpAk=");

    String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;	
    conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2,dbUser_tDBOutput_2,dbPwd_tDBOutput_2);
	
		resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
	
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;

   int batchSize_tDBOutput_2 = 10000;
   int batchSizeCounter_tDBOutput_2=0;

if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
    tableName_tDBOutput_2 = "dim_location";
} else {
    tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "].[" + "dim_location";
}
	int count_tDBOutput_2=0;

        String update_tDBOutput_2 = "UPDATE [" + tableName_tDBOutput_2 + "] SET [Gouvernorat] = ? WHERE [Code_lieu] = ?";
        java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
        resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_5", false);
		start_Hash.put("tMap_5", System.currentTimeMillis());
		
	
	currentComponent="tMap_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tMap_5 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
					globalMap.get( "tHash_Lookup_row6" ))
					;					
					
	

row6Struct row6HashKey = new row6Struct();
row6Struct row6Default = new row6Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_5__Struct  {
}
Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
add_locationStruct add_location_tmp = new add_locationStruct();
update_locationStruct update_location_tmp = new update_locationStruct();
// ###############################

        
        



        









 



/**
 * [tMap_5 begin ] stop
 */



	
	/**
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_1", false);
		start_Hash.put("tUniqRow_1", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out4");
					}
				
		int tos_count_tUniqRow_1 = 0;
		

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					String Code_lieu;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.Code_lieu == null) ? 0 : this.Code_lieu.hashCode());
								
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
				
									if (this.Code_lieu == null) {
										if (other.Code_lieu != null) 
											return false;
								
									} else if (!this.Code_lieu.equals(other.Code_lieu))
								 
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
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
out4Struct out4_tmp = new out4Struct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tUnite_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUnite_1", false);
		start_Hash.put("tUnite_1", System.currentTimeMillis());
		
	
	currentComponent="tUnite_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out3","out2","out1");
					}
				
		int tos_count_tUnite_1 = 0;
		

int nb_line_tUnite_1 = 0;

 



/**
 * [tUnite_1 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Vqz9LBDksbfSZf2sA17cEZaheqh3eVT/YzKg6KjqaHcnrF5ANAw=");
				
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

		    String dbquery_tDBInput_1 = "select dbo.scouts_repartition_geographique_SA.Code_lieu,dbo.scouts_repartition_geographique_SA.Gouvernorat,dbo.scouts_r"
+"epartition_geographique_SA.Nombre \nfrom youth_leadership_and_outdoor_education.dbo.scouts_repartition_geographique_SA";
		    

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
								row1.Code_lieu = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Code_lieu = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Code_lieu = tmpContent_tDBInput_1;
                }
            } else {
                row1.Code_lieu = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.Gouvernorat = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Gouvernorat = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.Gouvernorat = tmpContent_tDBInput_1;
                }
            } else {
                row1.Gouvernorat = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.Nombre = null;
							} else {
		                          
            row1.Nombre = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    row1.Nombre = null;
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
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.Code_lieu = row1.Code_lieu ;
out1_tmp.Gouvernorat = row1.Gouvernorat ;
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
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"out1"
									
							);
						}
						
//////////
 

// for output
			row4 = new row4Struct();
								
			row4.Code_lieu = out1.Code_lieu;								
			row4.Gouvernorat = out1.Gouvernorat;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

out4 = null;


// # Output table : 'out4'
out4_tmp.Code_lieu = row4.Code_lieu ;
out4_tmp.Gouvernorat = row4.Gouvernorat ;
out4 = out4_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "out4"
if(out4 != null) { 



	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out4"
						
						);
					}
					
row5 = null;			
if(out4.Code_lieu == null){
	finder_tUniqRow_1.Code_lieu = null;
}else{
	finder_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(out4.Code_lieu == null){
	new_tUniqRow_1.Code_lieu = null;
}else{
	new_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row5 == null){ 
	
	row5 = new row5Struct();
}row5.Code_lieu = out4.Code_lieu;			row5.Gouvernorat = out4.Gouvernorat;					
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
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row6" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow6 = false;
       		  	    	
       		  	    	
 							row6Struct row6ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_5 = false;
								
                        		    		    row6HashKey.Code_lieu = row5.Code_lieu ;
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.Code_lieu = '" + row6HashKey.Code_lieu + "'");
								} // G 071
							

							row6Struct row6 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row6Struct fromLookup_row6 = null;
							row6 = row6Default;
										 
							
								 
							
							
								if (tHash_Lookup_row6 !=null && tHash_Lookup_row6.hasNext()) { // G 099
								
							
								
								fromLookup_row6 = tHash_Lookup_row6.next();

							
							
								} // G 099
							
							

							if(fromLookup_row6 != null) {
								row6 = fromLookup_row6;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
        // ###############################
        // # Output tables

add_location = null;
update_location = null;


// # Output table : 'add_location'
// # Filter conditions 
if( 

row6.Code_lieu == null

 ) {
add_location_tmp.Code_lieu = row5.Code_lieu ;
add_location_tmp.Gouvernorat = row5.Gouvernorat ;
add_location = add_location_tmp;
} // closing filter/reject

// # Output table : 'update_location'
// # Filter conditions 
if( 

row6.Code_lieu != null

 ) {
update_location_tmp.Code_lieu = row5.Code_lieu ;
update_location_tmp.Gouvernorat = row5.Gouvernorat ;
update_location = update_location_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "add_location"
if(add_location != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"add_location"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(add_location.Code_lieu == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, add_location.Code_lieu);
}

                    if(add_location.Gouvernorat == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(2, add_location.Gouvernorat);
} else {
pstmt_tDBOutput_1.setString(2, add_location.Gouvernorat);
}
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

} // End of branch "add_location"




// Start of branch "update_location"
if(update_location != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"update_location"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(update_location.Gouvernorat == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(1, update_location.Gouvernorat);
} else {
pstmt_tDBOutput_2.setString(1, update_location.Gouvernorat);
}
}


                    if(update_location.Code_lieu == null) {
pstmt_tDBOutput_2.setNull(2 + count_tDBOutput_2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2 + count_tDBOutput_2, update_location.Code_lieu);
}


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

} // End of branch "update_location"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */

} // End of branch "out4"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
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
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
out2Struct out2_tmp = new out2Struct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:qFHXqeLMZ+UN825o5GczA+Mj+nEHcGFj4o7kg98QVqfkSQopWtg=");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
		    String port_tDBInput_2 = "1433";
		    String dbname_tDBInput_2 = "youth_leadership_and_outdoor_education" ;		    
		    String url_tDBInput_2 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_2)) {
		    	url_tDBInput_2 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_2)) {		    
		    	url_tDBInput_2 += ";databaseName=" + "youth_leadership_and_outdoor_education"; 
		    }
		    url_tDBInput_2 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_2 = "dbo";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "select dbo.events_prediction_dataset.event_id,dbo.events_prediction_dataset.event,dbo.events_prediction_dataset.Code_li"
+"eu,dbo.events_prediction_dataset.location,dbo.events_prediction_dataset.lat,dbo.events_prediction_dataset.lon,dbo.events"
+"_prediction_dataset.month,dbo.events_prediction_dataset.season,dbo.events_prediction_dataset.event_duration_days,dbo.eve"
+"nts_prediction_dataset.temp_max_mean,dbo.events_prediction_dataset.rain_total,dbo.events_prediction_dataset.wind_max,dbo"
+".events_prediction_dataset.weather_score,dbo.events_prediction_dataset.good_weather \nfrom youth_leadership_and_outdoor_e"
+"ducation.dbo.events_prediction_dataset";
		    

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
								row2.event_id = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(1);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.event_id = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.event_id = tmpContent_tDBInput_2;
                }
            } else {
                row2.event_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.event = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.event = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.event = tmpContent_tDBInput_2;
                }
            } else {
                row2.event = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.Code_lieu = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.Code_lieu = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.Code_lieu = tmpContent_tDBInput_2;
                }
            } else {
                row2.Code_lieu = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.location = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.location = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.location = tmpContent_tDBInput_2;
                }
            } else {
                row2.location = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.lat = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.lat = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.lat = tmpContent_tDBInput_2;
                }
            } else {
                row2.lat = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.lon = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.lon = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.lon = tmpContent_tDBInput_2;
                }
            } else {
                row2.lon = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.month = null;
							} else {
		                          
            row2.month = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    row2.month = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.season = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.season = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.season = tmpContent_tDBInput_2;
                }
            } else {
                row2.season = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row2.event_duration_days = null;
							} else {
		                          
            row2.event_duration_days = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    row2.event_duration_days = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row2.temp_max_mean = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(10);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.temp_max_mean = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.temp_max_mean = tmpContent_tDBInput_2;
                }
            } else {
                row2.temp_max_mean = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row2.rain_total = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.rain_total = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.rain_total = tmpContent_tDBInput_2;
                }
            } else {
                row2.rain_total = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row2.wind_max = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(12);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.wind_max = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.wind_max = tmpContent_tDBInput_2;
                }
            } else {
                row2.wind_max = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row2.weather_score = null;
							} else {
		                          
            row2.weather_score = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    row2.weather_score = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row2.good_weather = null;
							} else {
	                         		
            row2.good_weather = rs_tDBInput_2.getBoolean(14);
            if(rs_tDBInput_2.wasNull()){
                    row2.good_weather = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row2.date_code = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(15);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.date_code = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.date_code = tmpContent_tDBInput_2;
                }
            } else {
                row2.date_code = null;
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
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

out2 = null;


// # Output table : 'out2'
out2_tmp.Code_lieu = row2.Code_lieu ;
out2_tmp.location = row2.location ;
out2 = out2_tmp;
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
// Start of branch "out2"
if(out2 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"out2"
									
							);
						}
						
//////////
 

// for output
			row4 = new row4Struct();
								
			row4.Code_lieu = out2.Code_lieu;								
			row4.Gouvernorat = out2.location;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

out4 = null;


// # Output table : 'out4'
out4_tmp.Code_lieu = row4.Code_lieu ;
out4_tmp.Gouvernorat = row4.Gouvernorat ;
out4 = out4_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "out4"
if(out4 != null) { 



	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out4"
						
						);
					}
					
row5 = null;			
if(out4.Code_lieu == null){
	finder_tUniqRow_1.Code_lieu = null;
}else{
	finder_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(out4.Code_lieu == null){
	new_tUniqRow_1.Code_lieu = null;
}else{
	new_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row5 == null){ 
	
	row5 = new row5Struct();
}row5.Code_lieu = out4.Code_lieu;			row5.Gouvernorat = out4.Gouvernorat;					
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
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row6" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow6 = false;
       		  	    	
       		  	    	
 							row6Struct row6ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_5 = false;
								
                        		    		    row6HashKey.Code_lieu = row5.Code_lieu ;
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.Code_lieu = '" + row6HashKey.Code_lieu + "'");
								} // G 071
							

							row6Struct row6 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row6Struct fromLookup_row6 = null;
							row6 = row6Default;
										 
							
								 
							
							
								if (tHash_Lookup_row6 !=null && tHash_Lookup_row6.hasNext()) { // G 099
								
							
								
								fromLookup_row6 = tHash_Lookup_row6.next();

							
							
								} // G 099
							
							

							if(fromLookup_row6 != null) {
								row6 = fromLookup_row6;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
        // ###############################
        // # Output tables

add_location = null;
update_location = null;


// # Output table : 'add_location'
// # Filter conditions 
if( 

row6.Code_lieu == null

 ) {
add_location_tmp.Code_lieu = row5.Code_lieu ;
add_location_tmp.Gouvernorat = row5.Gouvernorat ;
add_location = add_location_tmp;
} // closing filter/reject

// # Output table : 'update_location'
// # Filter conditions 
if( 

row6.Code_lieu != null

 ) {
update_location_tmp.Code_lieu = row5.Code_lieu ;
update_location_tmp.Gouvernorat = row5.Gouvernorat ;
update_location = update_location_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "add_location"
if(add_location != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"add_location"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(add_location.Code_lieu == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, add_location.Code_lieu);
}

                    if(add_location.Gouvernorat == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(2, add_location.Gouvernorat);
} else {
pstmt_tDBOutput_1.setString(2, add_location.Gouvernorat);
}
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

} // End of branch "add_location"




// Start of branch "update_location"
if(update_location != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"update_location"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(update_location.Gouvernorat == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(1, update_location.Gouvernorat);
} else {
pstmt_tDBOutput_2.setString(1, update_location.Gouvernorat);
}
}


                    if(update_location.Code_lieu == null) {
pstmt_tDBOutput_2.setNull(2 + count_tDBOutput_2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2 + count_tDBOutput_2, update_location.Code_lieu);
}


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

} // End of branch "update_location"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */

} // End of branch "out4"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "out2"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
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
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */




	
	/**
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
out3Struct out3_tmp = new out3Struct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:aMiF7YqASymZsQSQ1GvZ5kPy/rxMX7i8ea/q+Y7MwIWrdV8BN4c=");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
		    String port_tDBInput_3 = "1433";
		    String dbname_tDBInput_3 = "youth_leadership_and_outdoor_education" ;		    
		    String url_tDBInput_3 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_3)) {
		    	url_tDBInput_3 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_3)) {		    
		    	url_tDBInput_3 += ";databaseName=" + "youth_leadership_and_outdoor_education"; 
		    }
		    url_tDBInput_3 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_3 = "dbo";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "select dbo.sponsor_SA.ID_Sponsor,dbo.sponsor_SA.Code_Sponsor,dbo.sponsor_SA.Nom_Sponsor,dbo.sponsor_SA.Type_Sponsor,dbo"
+".sponsor_SA.Secteur,dbo.sponsor_SA.Theme_Sponsorship,dbo.sponsor_SA.Unite,dbo.sponsor_SA.Saison,dbo.sponsor_SA.Date_Enga"
+"gement,dbo.sponsor_SA.Date_Reception,dbo.sponsor_SA.Montant_Promis_TND,dbo.sponsor_SA.Montant_Recu_TND,dbo.sponsor_SA.St"
+"atut,dbo.sponsor_SA.Affectation_Budgetaire,dbo.sponsor_SA.Code_lieu,dbo.sponsor_SA.Gouvernorat_Sponsor,dbo.sponsor_SA.No"
+"tes \nfrom youth_leadership_and_outdoor_education.dbo.sponsor_SA";
		    

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
								row3.ID_Sponsor = null;
							} else {
		                          
            row3.ID_Sponsor = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    row3.ID_Sponsor = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.Code_Sponsor = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Code_Sponsor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Code_Sponsor = tmpContent_tDBInput_3;
                }
            } else {
                row3.Code_Sponsor = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row3.Nom_Sponsor = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Nom_Sponsor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Nom_Sponsor = tmpContent_tDBInput_3;
                }
            } else {
                row3.Nom_Sponsor = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row3.Type_Sponsor = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Type_Sponsor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Type_Sponsor = tmpContent_tDBInput_3;
                }
            } else {
                row3.Type_Sponsor = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row3.Secteur = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Secteur = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Secteur = tmpContent_tDBInput_3;
                }
            } else {
                row3.Secteur = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row3.Theme_Sponsorship = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Theme_Sponsorship = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Theme_Sponsorship = tmpContent_tDBInput_3;
                }
            } else {
                row3.Theme_Sponsorship = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row3.Unite = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Unite = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Unite = tmpContent_tDBInput_3;
                }
            } else {
                row3.Unite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 8) {
								row3.Saison = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(8);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Saison = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Saison = tmpContent_tDBInput_3;
                }
            } else {
                row3.Saison = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 9) {
								row3.Date_Engagement = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(9);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Date_Engagement = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Date_Engagement = tmpContent_tDBInput_3;
                }
            } else {
                row3.Date_Engagement = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 10) {
								row3.Date_Reception = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(10);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Date_Reception = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Date_Reception = tmpContent_tDBInput_3;
                }
            } else {
                row3.Date_Reception = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 11) {
								row3.Montant_Promis_TND = null;
							} else {
		                          
            row3.Montant_Promis_TND = rs_tDBInput_3.getInt(11);
            if(rs_tDBInput_3.wasNull()){
                    row3.Montant_Promis_TND = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 12) {
								row3.Montant_Recu_TND = null;
							} else {
		                          
            row3.Montant_Recu_TND = rs_tDBInput_3.getInt(12);
            if(rs_tDBInput_3.wasNull()){
                    row3.Montant_Recu_TND = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 13) {
								row3.Statut = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(13);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Statut = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Statut = tmpContent_tDBInput_3;
                }
            } else {
                row3.Statut = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 14) {
								row3.Affectation_Budgetaire = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(14);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Affectation_Budgetaire = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Affectation_Budgetaire = tmpContent_tDBInput_3;
                }
            } else {
                row3.Affectation_Budgetaire = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 15) {
								row3.Code_lieu = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(15);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Code_lieu = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Code_lieu = tmpContent_tDBInput_3;
                }
            } else {
                row3.Code_lieu = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 16) {
								row3.Gouvernorat_Sponsor = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(16);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Gouvernorat_Sponsor = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Gouvernorat_Sponsor = tmpContent_tDBInput_3;
                }
            } else {
                row3.Gouvernorat_Sponsor = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 17) {
								row3.Notes = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(17);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.Notes = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.Notes = tmpContent_tDBInput_3;
                }
            } else {
                row3.Notes = null;
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
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

out3 = null;


// # Output table : 'out3'
out3_tmp.Code_lieu = row3.Code_lieu ;
out3_tmp.Gouvernorat_Sponsor = row3.Gouvernorat_Sponsor ;
out3 = out3_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "out3"
if(out3 != null) { 



	
	/**
	 * [tUnite_1 main ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	
						if(execStat){
							runStat.updateStatOnConnection(iterateId,1,1
								
									,"out3"
									
							);
						}
						
//////////
 

// for output
			row4 = new row4Struct();
								
			row4.Code_lieu = out3.Code_lieu;								
			row4.Gouvernorat = out3.Gouvernorat_Sponsor;			

			nb_line_tUnite_1++;

//////////
 


	tos_count_tUnite_1++;

/**
 * [tUnite_1 main ] stop
 */
	
	/**
	 * [tUnite_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

out4 = null;


// # Output table : 'out4'
out4_tmp.Code_lieu = row4.Code_lieu ;
out4_tmp.Gouvernorat = row4.Gouvernorat ;
out4 = out4_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "out4"
if(out4 != null) { 



	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out4"
						
						);
					}
					
row5 = null;			
if(out4.Code_lieu == null){
	finder_tUniqRow_1.Code_lieu = null;
}else{
	finder_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(out4.Code_lieu == null){
	new_tUniqRow_1.Code_lieu = null;
}else{
	new_tUniqRow_1.Code_lieu = out4.Code_lieu.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row5 == null){ 
	
	row5 = new row5Struct();
}row5.Code_lieu = out4.Code_lieu;			row5.Gouvernorat = out4.Gouvernorat;					
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
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row6" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow6 = false;
       		  	    	
       		  	    	
 							row6Struct row6ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_5 = false;
								
                        		    		    row6HashKey.Code_lieu = row5.Code_lieu ;
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.Code_lieu = '" + row6HashKey.Code_lieu + "'");
								} // G 071
							

							row6Struct row6 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row6Struct fromLookup_row6 = null;
							row6 = row6Default;
										 
							
								 
							
							
								if (tHash_Lookup_row6 !=null && tHash_Lookup_row6.hasNext()) { // G 099
								
							
								
								fromLookup_row6 = tHash_Lookup_row6.next();

							
							
								} // G 099
							
							

							if(fromLookup_row6 != null) {
								row6 = fromLookup_row6;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
        // ###############################
        // # Output tables

add_location = null;
update_location = null;


// # Output table : 'add_location'
// # Filter conditions 
if( 

row6.Code_lieu == null

 ) {
add_location_tmp.Code_lieu = row5.Code_lieu ;
add_location_tmp.Gouvernorat = row5.Gouvernorat ;
add_location = add_location_tmp;
} // closing filter/reject

// # Output table : 'update_location'
// # Filter conditions 
if( 

row6.Code_lieu != null

 ) {
update_location_tmp.Code_lieu = row5.Code_lieu ;
update_location_tmp.Gouvernorat = row5.Gouvernorat ;
update_location = update_location_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "add_location"
if(add_location != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"add_location"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(add_location.Code_lieu == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, add_location.Code_lieu);
}

                    if(add_location.Gouvernorat == null) {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_1.setNString(2, add_location.Gouvernorat);
} else {
pstmt_tDBOutput_1.setString(2, add_location.Gouvernorat);
}
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

} // End of branch "add_location"




// Start of branch "update_location"
if(update_location != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"update_location"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(update_location.Gouvernorat == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {String driver = null;
driver = "MSSQL_PROP";
if ("MSSQL_PROP".equals(driver)) {
pstmt_tDBOutput_2.setNString(1, update_location.Gouvernorat);
} else {
pstmt_tDBOutput_2.setString(1, update_location.Gouvernorat);
}
}


                    if(update_location.Code_lieu == null) {
pstmt_tDBOutput_2.setNull(2 + count_tDBOutput_2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2 + count_tDBOutput_2, update_location.Code_lieu);
}


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

} // End of branch "update_location"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */

} // End of branch "out4"




	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tUnite_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 process_data_end ] stop
 */

} // End of branch "out3"




	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
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
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */



	
	/**
	 * [tUnite_1 end ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

globalMap.put("tUnite_1_NB_LINE", nb_line_tUnite_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out3","out2","out1");
			  	}
			  	
 

ok_Hash.put("tUnite_1", true);
end_Hash.put("tUnite_1", System.currentTimeMillis());




/**
 * [tUnite_1 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out4");
			  	}
			  	
 

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




/**
 * [tUniqRow_1 end ] stop
 */

	
	/**
	 * [tMap_5 end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row6 != null) {
						tHash_Lookup_row6.endGet();
					}
					globalMap.remove( "tHash_Lookup_row6" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tMap_5", true);
end_Hash.put("tMap_5", System.currentTimeMillis());




/**
 * [tMap_5 end ] stop
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"add_location");
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"update_location");
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
				
					     			//free memory for "tMap_5"
					     			globalMap.remove("tHash_Lookup_row6"); 
				     			
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */



	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 finally ] stop
 */



	
	/**
	 * [tUnite_1 finally ] start
	 */

	

	
	
	currentComponent="tUnite_1";

	

 



/**
 * [tUnite_1 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 finally ] stop
 */

	
	/**
	 * [tMap_5 finally ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 finally ] stop
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
	


public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_dim_location_methode2 = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Code_lieu;

				public String getCode_lieu () {
					return this.Code_lieu;
				}
				
			    public String Gouvernorat;

				public String getGouvernorat () {
					return this.Gouvernorat;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Code_lieu == null) ? 0 : this.Code_lieu.hashCode());
					
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
		final row6Struct other = (row6Struct) obj;
		
						if (this.Code_lieu == null) {
							if (other.Code_lieu != null)
								return false;
						
						} else if (!this.Code_lieu.equals(other.Code_lieu))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.Code_lieu = this.Code_lieu;
	            other.Gouvernorat = this.Gouvernorat;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

		other.Code_lieu = this.Code_lieu;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_dim_location_methode2.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_dim_location_methode2.length == 0) {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_dim_location_methode2 = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_dim_location_methode2, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_dim_location_methode2) {

        	try {

        		int length = 0;
		
					this.Code_lieu = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_lieu,dos);
					
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
		
						this.Gouvernorat = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Gouvernorat = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.Gouvernorat, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.Gouvernorat, dos, objectOut);
					
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
		sb.append("Code_lieu="+Code_lieu);
		sb.append(",Gouvernorat="+Gouvernorat);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Code_lieu, other.Code_lieu);
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
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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



		row6Struct row6 = new row6Struct();




	
	/**
	 * [tAdvancedHash_row6 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row6", false);
		start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tAdvancedHash_row6 = 0;
		

			   		// connection name:row6
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row6,row6) | target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
			   		// linked node: tMap_5 - inputs:(row5,row6) outputs:(add_location,update_location)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row6Struct>getLookup(matchingModeEnum_row6);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row6 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_4  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4); 
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "talend_user";
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:deJC0Cf7IBszp9qDFM8y/ODTLQyRpGQO9emKNpD9PQZaOYBCqKE=");
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
		    String port_tDBInput_4 = "1433";
		    String dbname_tDBInput_4 = "scout_DW" ;		    
		    String url_tDBInput_4 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_4)) {
		    	url_tDBInput_4 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_4)) {		    
		    	url_tDBInput_4 += ";databaseName=" + "scout_DW"; 
		    }
		    url_tDBInput_4 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_4 = "dbo";
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "select dbo.dim_location.Code_lieu,dbo.dim_location.Gouvernorat,dbo.dim_location.id_gouvernorat \nfrom scout_DW.dbo.dim_l"
+"ocation";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row6.Code_lieu = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(1);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.Code_lieu = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row6.Code_lieu = tmpContent_tDBInput_4;
                }
            } else {
                row6.Code_lieu = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row6.Gouvernorat = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.Gouvernorat = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row6.Gouvernorat = tmpContent_tDBInput_4;
                }
            } else {
                row6.Gouvernorat = null;
            }
		                    }
					





 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					


			   
			   

					row6Struct row6_HashRow = new row6Struct();
		   	   	   
				
				row6_HashRow.Code_lieu = row6.Code_lieu;
				
				row6_HashRow.Gouvernorat = row6.Gouvernorat;
				
			tHash_Lookup_row6.put(row6_HashRow);
			
            




 


	tos_count_tAdvancedHash_row6++;

/**
 * [tAdvancedHash_row6 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);

 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

tHash_Lookup_row6.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row6", true);
end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());




/**
 * [tAdvancedHash_row6 end ] stop
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
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
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
        final dim_location_methode2 dim_location_methode2Class = new dim_location_methode2();

        int exitCode = dim_location_methode2Class.runJobInTOS(args);

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
            java.io.InputStream inContext = dim_location_methode2.class.getClassLoader().getResourceAsStream("projet_pi_bi/dim_location_methode2_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = dim_location_methode2.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : dim_location_methode2");
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
 *     250705 characters generated by Talend Open Studio for Data Integration 
 *     on the 28 février 2026 à 18:02:40 WAT
 ************************************************************************************************/