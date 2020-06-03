# RDBCnew

R JDBC access for Oracle ADW

patched version of class.R and Java source is included

Restrictions:
  your wallet position is sticked to /opt/oracle/network/admin


[Binary Download](https://github.com/vascarpenter/RDBCnew/releases)

How to use it in R:

    > setwd("DownloadedDirectory")
    > install.packages("RJDBC.tar.gz")
    'pkgs'から 'repos = NULL' を推測 
    untar2(tarfile, files, list, exdir, restore_times) で警告がありました: 
    using pax extended headers
    * installing *source* package ‘RJDBC’ ...
    ** using staged installation
    ** R
    ** inst
    ** byte-compile and prepare package for lazy loading
    ** help
    *** installing help indices
    ** building package indices
    ** testing if installed package can be loaded from temporary location
    ** testing if installed package can be loaded from final location
    ** testing if installed package keeps a record of temporary installation path
    * DONE (RJDBC)
    > library(RJDBC)
    > drv <- JDBC("oracle.jdbc.driver.OracleDriver", "/opt/oracle/instantclient_19_3/ojdbc8.jar")
    > conn <- dbConnect(drv, "jdbc:oracle:thin:@YOURDATABASE_tp", "admin", "YOURPASSWORD")
    > dn <- dbReadTable(conn,"dchild")
    > 
    > dn[1:5,1:8]
    ID NUMS          CNAME                DNAME POINT RBPOINT WBPOINT DRPOINT
    1 111    1         パケト  きゃぴきゃぴ パケト   8.4     8.4     8.4     8.4
    2   1    7         コウガ         化身のコウガ   9.8     9.8     9.8     9.8
    3   2    3       ティスベ      迷宮の ティスベ   9.8     9.8     9.8     9.8
    4   3    5 ニュービーモナ         ルーキーモナ   9.8     9.8     9.8     9.8
    5   4    3     バートリー ブラッディバートリー   9.8     9.8     9.8     9.8
    > 