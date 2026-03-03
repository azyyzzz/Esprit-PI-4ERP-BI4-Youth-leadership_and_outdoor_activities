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


package projet_pi_bi.fact_activities_0_1;

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
 * Job: Fact_Activities Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Fact_Activities implements TalendJob {

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
	private final String jobName = "Fact_Activities";
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
				Fact_Activities.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Fact_Activities.this, new Object[] { e , currentComponent, globalMap});
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

			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];

	
			    public int date_FK;

				public int getDate_FK () {
					return this.date_FK;
				}
				
			    public int unit_FK;

				public int getUnit_FK () {
					return this.unit_FK;
				}
				
			    public int type_FK;

				public int getType_FK () {
					return this.type_FK;
				}
				
			    public Integer Nb_Activites;

				public Integer getNb_Activites () {
					return this.Nb_Activites;
				}
				
			    public Integer Nb_Participants;

				public Integer getNb_Participants () {
					return this.Nb_Participants;
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
			        this.date_FK = dis.readInt();
					
			        this.unit_FK = dis.readInt();
					
			        this.type_FK = dis.readInt();
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
			        this.date_FK = dis.readInt();
					
			        this.unit_FK = dis.readInt();
					
			        this.type_FK = dis.readInt();
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.date_FK);
					
					// int
				
		            	dos.writeInt(this.unit_FK);
					
					// int
				
		            	dos.writeInt(this.type_FK);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.date_FK);
					
					// int
				
		            	dos.writeInt(this.unit_FK);
					
					// int
				
		            	dos.writeInt(this.type_FK);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("date_FK="+String.valueOf(date_FK));
		sb.append(",unit_FK="+String.valueOf(unit_FK));
		sb.append(",type_FK="+String.valueOf(type_FK));
		sb.append(",Nb_Activites="+String.valueOf(Nb_Activites));
		sb.append(",Nb_Participants="+String.valueOf(Nb_Participants));
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
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];

	
			    public String Code_unite;

				public String getCode_unite () {
					return this.Code_unite;
				}
				
			    public String unite;

				public String getUnite () {
					return this.unite;
				}
				
			    public String Code_type;

				public String getCode_type () {
					return this.Code_type;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				
			    public String Activite;

				public String getActivite () {
					return this.Activite;
				}
				
			    public Integer Nb_Activites;

				public Integer getNb_Activites () {
					return this.Nb_Activites;
				}
				
			    public Integer Nb_Participants;

				public Integer getNb_Participants () {
					return this.Nb_Participants;
				}
				
			    public java.util.Date date_code;

				public java.util.Date getDate_code () {
					return this.date_code;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
					this.unite = readString(dis);
					
					this.Code_type = readString(dis);
					
					this.Type = readString(dis);
					
					this.Activite = readString(dis);
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
					this.date_code = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
					this.unite = readString(dis);
					
					this.Code_type = readString(dis);
					
					this.Type = readString(dis);
					
					this.Activite = readString(dis);
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
					this.date_code = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// String
				
						writeString(this.unite,dos);
					
					// String
				
						writeString(this.Code_type,dos);
					
					// String
				
						writeString(this.Type,dos);
					
					// String
				
						writeString(this.Activite,dos);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
					// java.util.Date
				
						writeDate(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// String
				
						writeString(this.unite,dos);
					
					// String
				
						writeString(this.Code_type,dos);
					
					// String
				
						writeString(this.Type,dos);
					
					// String
				
						writeString(this.Activite,dos);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
					// java.util.Date
				
						writeDate(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_unite="+Code_unite);
		sb.append(",unite="+unite);
		sb.append(",Code_type="+Code_type);
		sb.append(",Type="+Type);
		sb.append(",Activite="+Activite);
		sb.append(",Nb_Activites="+String.valueOf(Nb_Activites));
		sb.append(",Nb_Participants="+String.valueOf(Nb_Participants));
		sb.append(",date_code="+String.valueOf(date_code));
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

public static class after_tDBInput_3Struct implements routines.system.IPersistableRow<after_tDBInput_3Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];

	
			    public String Code_unite;

				public String getCode_unite () {
					return this.Code_unite;
				}
				
			    public String unite;

				public String getUnite () {
					return this.unite;
				}
				
			    public String Code_type;

				public String getCode_type () {
					return this.Code_type;
				}
				
			    public String Type;

				public String getType () {
					return this.Type;
				}
				
			    public String Activite;

				public String getActivite () {
					return this.Activite;
				}
				
			    public Integer Nb_Activites;

				public Integer getNb_Activites () {
					return this.Nb_Activites;
				}
				
			    public Integer Nb_Participants;

				public Integer getNb_Participants () {
					return this.Nb_Participants;
				}
				
			    public java.util.Date date_code;

				public java.util.Date getDate_code () {
					return this.date_code;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
					this.unite = readString(dis);
					
					this.Code_type = readString(dis);
					
					this.Type = readString(dis);
					
					this.Activite = readString(dis);
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
					this.date_code = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.Code_unite = readString(dis);
					
					this.unite = readString(dis);
					
					this.Code_type = readString(dis);
					
					this.Type = readString(dis);
					
					this.Activite = readString(dis);
					
						this.Nb_Activites = readInteger(dis);
					
						this.Nb_Participants = readInteger(dis);
					
					this.date_code = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// String
				
						writeString(this.unite,dos);
					
					// String
				
						writeString(this.Code_type,dos);
					
					// String
				
						writeString(this.Type,dos);
					
					// String
				
						writeString(this.Activite,dos);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
					// java.util.Date
				
						writeDate(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Code_unite,dos);
					
					// String
				
						writeString(this.unite,dos);
					
					// String
				
						writeString(this.Code_type,dos);
					
					// String
				
						writeString(this.Type,dos);
					
					// String
				
						writeString(this.Activite,dos);
					
					// Integer
				
						writeInteger(this.Nb_Activites,dos);
					
					// Integer
				
						writeInteger(this.Nb_Participants,dos);
					
					// java.util.Date
				
						writeDate(this.date_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Code_unite="+Code_unite);
		sb.append(",unite="+unite);
		sb.append(",Code_type="+Code_type);
		sb.append(",Type="+Type);
		sb.append(",Activite="+Activite);
		sb.append(",Nb_Activites="+String.valueOf(Nb_Activites));
		sb.append(",Nb_Participants="+String.valueOf(Nb_Participants));
		sb.append(",date_code="+String.valueOf(date_code));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_3Struct other) {

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


		tDBInput_4Process(globalMap);
		tDBInput_1Process(globalMap);
		tDBInput_5Process(globalMap);

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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:j6LJ1pNjxOfG8dtHvULncISHB6qmB33KziFfjE5W3nHk01e7yQI=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

   int batchSize_tDBOutput_1 = 10000;
   int batchSizeCounter_tDBOutput_1=0;

if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "Fact_activite";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "Fact_activite";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([date_FK] INT  not null ,[unit_FK] INT  not null ,[type_FK] INT  not null ,[Nb_Activites] INT ,[Nb_Participants] INT )");
                                    }
                                }
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([date_FK],[unit_FK],[type_FK],[Nb_Activites],[Nb_Participants]) VALUES (?,?,?,?,?)";
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
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
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
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:OzxW/76v9pJZwwsqyTMtR3nWQRASJqIj5Cwa2j7xNKSXrxnSeLE=");
				
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

		    String dbquery_tDBInput_3 = "select dbo.\"activites_scouts_tunisie_2025_SA\".Code_unite,dbo.\"activites_scouts_tunisie_2025_SA\".unite,dbo.\"activit"
+"es_scouts_tunisie_2025_SA\".Code_type,dbo.\"activites_scouts_tunisie_2025_SA\".Type,dbo.\"activites_scouts_tunisie_2025_"
+"SA\".Activite,dbo.\"activites_scouts_tunisie_2025_SA\".Nb_Activites,dbo.\"activites_scouts_tunisie_2025_SA\".Nb_Particip"
+"ants,dbo.\"activites_scouts_tunisie_2025_SA\".date_code \nfrom dbo.\"activites_scouts_tunisie_2025_SA\"";
		    

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
								row1.Code_unite = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(1);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Code_unite = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row1.Code_unite = tmpContent_tDBInput_3;
                }
            } else {
                row1.Code_unite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row1.unite = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.unite = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row1.unite = tmpContent_tDBInput_3;
                }
            } else {
                row1.unite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row1.Code_type = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Code_type = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row1.Code_type = tmpContent_tDBInput_3;
                }
            } else {
                row1.Code_type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row1.Type = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Type = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row1.Type = tmpContent_tDBInput_3;
                }
            } else {
                row1.Type = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row1.Activite = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.Activite = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row1.Activite = tmpContent_tDBInput_3;
                }
            } else {
                row1.Activite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row1.Nb_Activites = null;
							} else {
		                          
            row1.Nb_Activites = rs_tDBInput_3.getInt(6);
            if(rs_tDBInput_3.wasNull()){
                    row1.Nb_Activites = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row1.Nb_Participants = null;
							} else {
		                          
            row1.Nb_Participants = rs_tDBInput_3.getInt(7);
            if(rs_tDBInput_3.wasNull()){
                    row1.Nb_Participants = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 8) {
								row1.date_code = null;
							} else {
										
			row1.date_code = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 8);
			
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
								
                        		    		    row2HashKey.full_date = row1.date_code  == null ? null : new java.util.Date(row1.date_code .getTime());
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.full_date = '" + row2HashKey.full_date + "'");
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
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row3HashKey.unit_code = row1.Code_unite ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.unit_code = '" + row3HashKey.unit_code + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row4HashKey.type_code = row1.Code_type ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.type_code = '" + row4HashKey.type_code + "'");
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
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'out1'
out1_tmp.date_FK = row2.date_id ;
out1_tmp.unit_FK = row3.unit_id ;
out1_tmp.type_FK = row4.type_id ;
out1_tmp.Nb_Activites = row1.Nb_Activites ;
out1_tmp.Nb_Participants = row1.Nb_Participants ;
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
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    pstmt_tDBOutput_1.setInt(1, out1.date_FK);

                    pstmt_tDBOutput_1.setInt(2, out1.unit_FK);

                    pstmt_tDBOutput_1.setInt(3, out1.type_FK);

                    if(out1.Nb_Activites == null) {
pstmt_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(4, out1.Nb_Activites);
}

                    if(out1.Nb_Participants == null) {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(5, out1.Nb_Participants);
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
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
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
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
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
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int date_id;

				public int getDate_id () {
					return this.date_id;
				}
				
			    public java.util.Date full_date;

				public java.util.Date getFull_date () {
					return this.full_date;
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
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.full_date == null) ? 0 : this.full_date.hashCode());
					
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
		
						if (this.full_date == null) {
							if (other.full_date != null)
								return false;
						
						} else if (!this.full_date.equals(other.full_date))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.date_id = this.date_id;
	            other.full_date = this.full_date;
	            other.jour_nom = this.jour_nom;
	            other.mois_nom = this.mois_nom;
	            other.annee = this.annee;
	            other.trimestre = this.trimestre;
	            other.saison = this.saison;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.full_date = this.full_date;
	            	
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.full_date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.full_date = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.full_date,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.full_date,dos);
					
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
		
			            this.date_id = dis.readInt();
					
						this.jour_nom = readString(dis,ois);
					
						this.mois_nom = readString(dis,ois);
					
						this.annee = readInteger(dis,ois);
					
						this.trimestre = readInteger(dis,ois);
					
						this.saison = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.date_id = objectIn.readInt();
					
						this.jour_nom = readString(dis,objectIn);
					
						this.mois_nom = readString(dis,objectIn);
					
						this.annee = readInteger(dis,objectIn);
					
						this.trimestre = readInteger(dis,objectIn);
					
						this.saison = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.date_id);
					
						writeString(this.jour_nom, dos, oos);
					
						writeString(this.mois_nom, dos, oos);
					
					writeInteger(this.annee, dos, oos);
					
					writeInteger(this.trimestre, dos, oos);
					
						writeString(this.saison, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.date_id);
					
						writeString(this.jour_nom, dos, objectOut);
					
						writeString(this.mois_nom, dos, objectOut);
					
					writeInteger(this.annee, dos, objectOut);
					
					writeInteger(this.trimestre, dos, objectOut);
					
						writeString(this.saison, dos, objectOut);
					
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
		sb.append("date_id="+String.valueOf(date_id));
		sb.append(",full_date="+String.valueOf(full_date));
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
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.full_date, other.full_date);
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
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_3) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:WucnN+mN0EwIGdm+4yCv8gaLIjqUGYyFKvPK5SPNjZAVsaTmqQE=");
				
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

		    String dbquery_tDBInput_4 = "select dbo.dim_date.date_id,dbo.dim_date.full_date,dbo.dim_date.jour_nom,dbo.dim_date.mois_nom,dbo.dim_date.annee,dbo.d"
+"im_date.trimestre,dbo.dim_date.saison \nfrom scout_DW.dbo.dim_date";
		    

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
								row2.date_id = 0;
							} else {
		                          
            row2.date_id = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row2.full_date = null;
							} else {
										
			row2.full_date = mssqlGTU_tDBInput_4.getDate(rsmd_tDBInput_4, rs_tDBInput_4, 2);
			
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row2.jour_nom = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.jour_nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row2.jour_nom = tmpContent_tDBInput_4;
                }
            } else {
                row2.jour_nom = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row2.mois_nom = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(4);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.mois_nom = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row2.mois_nom = tmpContent_tDBInput_4;
                }
            } else {
                row2.mois_nom = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row2.annee = null;
							} else {
		                          
            row2.annee = rs_tDBInput_4.getInt(5);
            if(rs_tDBInput_4.wasNull()){
                    row2.annee = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row2.trimestre = null;
							} else {
		                          
            row2.trimestre = rs_tDBInput_4.getInt(6);
            if(rs_tDBInput_4.wasNull()){
                    row2.trimestre = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row2.saison = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(7);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.saison = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row2.saison = tmpContent_tDBInput_4;
                }
            } else {
                row2.saison = null;
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
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.date_id = row2.date_id;
				
				row2_HashRow.full_date = row2.full_date;
				
				row2_HashRow.jour_nom = row2.jour_nom;
				
				row2_HashRow.mois_nom = row2.mois_nom;
				
				row2_HashRow.annee = row2.annee;
				
				row2_HashRow.trimestre = row2.trimestre;
				
				row2_HashRow.saison = row2.saison;
				
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
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
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
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];
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
		final row3Struct other = (row3Struct) obj;
		
						if (this.unit_code == null) {
							if (other.unit_code != null)
								return false;
						
						} else if (!this.unit_code.equals(other.unit_code))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.unit_id = this.unit_id;
	            other.unite_name = this.unite_name;
	            other.unit_code = this.unit_code;
	            other.age_category = this.age_category;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

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
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.unit_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

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
    public int compareTo(row3Struct other) {

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



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tDBInput_1 - inputs:(after_tDBInput_3) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:0A9wNc+ktlpAGanGcX2EH07p3/mDwjCFcKtWb3akbyKf9H8Hr40=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
		    String port_tDBInput_1 = "1433";
		    String dbname_tDBInput_1 = "scout_DW" ;		    
		    String url_tDBInput_1 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_1)) {
		    	url_tDBInput_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_1)) {		    
		    	url_tDBInput_1 += ";databaseName=" + "scout_DW"; 
		    }
		    url_tDBInput_1 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_1 = "dbo";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "select dbo.dim_unite.unit_id,dbo.dim_unite.unite_name,dbo.dim_unite.unit_code,dbo.dim_unite.age_category \nfrom scout_DW"
+".dbo.dim_unite";
		    

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
								row3.unit_id = 0;
							} else {
		                          
            row3.unit_id = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row3.unite_name = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.unite_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row3.unite_name = tmpContent_tDBInput_1;
                }
            } else {
                row3.unite_name = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row3.unit_code = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.unit_code = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row3.unit_code = tmpContent_tDBInput_1;
                }
            } else {
                row3.unit_code = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row3.age_category = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.age_category = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row3.age_category = tmpContent_tDBInput_1;
                }
            } else {
                row3.age_category = null;
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
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.unit_id = row3.unit_id;
				
				row3_HashRow.unite_name = row3.unite_name;
				
				row3_HashRow.unit_code = row3.unit_code;
				
				row3_HashRow.age_category = row3.age_category;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
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
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
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
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
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
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PROJET_PI_BI_Fact_Activities = new byte[0];
    static byte[] commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String type_code;

				public String getType_code () {
					return this.type_code;
				}
				
			    public String type_name;

				public String getType_name () {
					return this.type_name;
				}
				
			    public int type_id;

				public int getType_id () {
					return this.type_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.type_code == null) ? 0 : this.type_code.hashCode());
					
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
		
						if (this.type_code == null) {
							if (other.type_code != null)
								return false;
						
						} else if (!this.type_code.equals(other.type_code))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.type_code = this.type_code;
	            other.type_name = this.type_name;
	            other.type_id = this.type_id;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.type_code = this.type_code;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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
			if(length > commonByteArray_PROJET_PI_BI_Fact_Activities.length) {
				if(length < 1024 && commonByteArray_PROJET_PI_BI_Fact_Activities.length == 0) {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[1024];
				} else {
   					commonByteArray_PROJET_PI_BI_Fact_Activities = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length);
			strReturn = new String(commonByteArray_PROJET_PI_BI_Fact_Activities, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.type_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PROJET_PI_BI_Fact_Activities) {

        	try {

        		int length = 0;
		
					this.type_code = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.type_code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.type_code,dos);
					
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
		
						this.type_name = readString(dis,ois);
					
			            this.type_id = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.type_name = readString(dis,objectIn);
					
			            this.type_id = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.type_name, dos, oos);
					
		            	dos.writeInt(this.type_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.type_name, dos, objectOut);
					
					objectOut.writeInt(this.type_id);
					
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
		sb.append("type_code="+type_code);
		sb.append(",type_name="+type_name);
		sb.append(",type_id="+String.valueOf(type_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.type_code, other.type_code);
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
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

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
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_3) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_5  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5); 
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			    java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "talend_user";
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:nGoG1l50C+SwsN6R4rAjbxp+X8APL1O6KoARHVJm6ewsCGb5CL8=");
				
				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;
				
		    String port_tDBInput_5 = "1433";
		    String dbname_tDBInput_5 = "scout_DW" ;		    
		    String url_tDBInput_5 = "jdbc:sqlserver://" + "localhost" ;
		    if (!"".equals(port_tDBInput_5)) {
		    	url_tDBInput_5 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_5)) {		    
		    	url_tDBInput_5 += ";databaseName=" + "scout_DW"; 
		    }
		    url_tDBInput_5 += ";appName=" + projectName + ";" + "encrypt=true;trustServerCertificate=true;";
		    String dbschema_tDBInput_5 = "dbo";
				
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5,dbUser_tDBInput_5,dbPwd_tDBInput_5);
		        
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "select dbo.dim_type_act_cam.type_code,dbo.dim_type_act_cam.type_name,dbo.dim_type_act_cam.type_id \nfrom scout_DW.dbo.di"
+"m_type_act_cam";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								row4.type_code = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(1);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.type_code = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row4.type_code = tmpContent_tDBInput_5;
                }
            } else {
                row4.type_code = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row4.type_name = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.type_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row4.type_name = tmpContent_tDBInput_5;
                }
            } else {
                row4.type_name = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row4.type_id = 0;
							} else {
		                          
            row4.type_id = rs_tDBInput_5.getInt(3);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
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
		   	   	   
				
				row4_HashRow.type_code = row4.type_code;
				
				row4_HashRow.type_name = row4.type_name;
				
				row4_HashRow.type_id = row4.type_id;
				
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
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
		if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
			
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);

 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
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
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
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
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
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
        final Fact_Activities Fact_ActivitiesClass = new Fact_Activities();

        int exitCode = Fact_ActivitiesClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Fact_Activities.class.getClassLoader().getResourceAsStream("projet_pi_bi/fact_activities_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Fact_Activities.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
errorCode = null;tDBInput_3Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_3) {
globalMap.put("tDBInput_3_SUBPROCESS_STATE", -1);

e_tDBInput_3.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Fact_Activities");
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
 *     152637 characters generated by Talend Open Studio for Data Integration 
 *     on the 28 février 2026 à 18:03:09 WAT
 ************************************************************************************************/