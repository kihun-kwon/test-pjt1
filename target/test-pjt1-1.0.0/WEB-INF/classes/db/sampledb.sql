CREATE MEMORY TABLE ORDER_T(ORDER_ID VARCHAR(200) NOT NULL PRIMARY KEY,FGKEY VARCHAR(200) NOT NULL,TRANSACTION_TYPE VARCHAR(10) NOT NULL,CURRENCY VARCHAR(5) NOT NULL,AMOUNT VARCHAR(10) NOT NULL,LANG VARCHAR(3) NOT NULL,PAYMENT_METHOD VARCHAR(10) NULL,MULTI_PAYMENT_METHOD VARCHAR(200) NULL,MID VARCHAR(100) NOT NULL,RETURN_URL VARCHAR(200) NOT NULL,STATUS_URL VARCHAR(200) NOT NULL,NAME VARCHAR(200) NOT NULL,PHONE_NUMBER VARCHAR(200) NULL,EMAIL VARCHAR(200) NOT NULL,RECEIPT_STATUS VARCHAR(1) NULL,AMOUNT_TAX_FREE VARCHAR(10) NULL,AMOUNT_TAXABLE VARCHAR(10) NULL,AMOUNT_VAT VARCHAR(10) NULL,AMOUNT_SERVICE_FEE VARCHAR(10) NULL,OTHER_PARAM VARCHAR(255) NULL,OTHER_PARAM2 VARCHAR(255) NULL)
CREATE MEMORY TABLE PRODUCT_T(PRODUCT_ID VARCHAR(200) NOT NULL PRIMARY KEY,ORDER_ID VARCHAR(200) NOT NULL,NAME VARCHAR(200) NOT NULL,QUANTITY VARCHAR(10) NOT NULL,UNIT_PRICE VARCHAR(10) NOT NULL,LINK VARCHAR(255) NOT NULL)
CREATE MEMORY TABLE SAMPLE(ID VARCHAR(16) NOT NULL PRIMARY KEY,NAME VARCHAR(50),DESCRIPTION VARCHAR(100),USE_YN CHAR(1),REG_USER VARCHAR(10))
CREATE MEMORY TABLE IDS(TABLE_NAME VARCHAR(16) NOT NULL PRIMARY KEY,NEXT_ID DECIMAL(30) NOT NULL)
SET SCHEMA PUBLIC
INSERT INTO SAMPLE VALUES('SAMPLE-00001','Runtime Environment','Foundation Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00002','Runtime Environment','Persistence Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00003','Runtime Environment','Presentation Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00004','Runtime Environment','Business Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00005','Runtime Environment','Batch Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00006','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00007','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00008','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00009','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00010','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00011','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00012','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00013','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00014','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00015','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00016','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00017','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00018','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00019','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00020','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00021','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00022','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00023','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00024','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00025','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00026','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00027','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00028','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00029','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00030','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00031','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00032','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00033','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00034','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00035','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00036','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00037','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00038','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00039','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00040','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00041','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00042','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00043','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00044','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00045','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00046','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00047','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00048','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00049','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00050','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00051','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00052','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00053','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00054','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00055','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00056','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00057','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00058','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00059','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00060','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00061','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00062','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00063','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00064','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00065','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00066','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00067','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00068','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00069','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00070','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00071','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00072','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00073','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00074','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00075','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00076','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00077','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00078','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00079','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00080','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00081','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00082','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00083','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00084','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00085','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00086','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00087','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00088','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00089','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00090','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00091','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00092','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00093','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00094','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00095','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00096','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00097','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00098','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00099','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00100','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00101','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00102','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00103','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00104','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00105','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00106','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00107','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00108','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00109','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00110','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00111','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00112','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00113','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO SAMPLE VALUES('SAMPLE-00114','Runtime Environment','Integration Layer','Y','eGov')
INSERT INTO IDS VALUES('SAMPLE',115)
