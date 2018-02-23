# Introduction
This is sample project created in AEM 6.2 that contains a component which has the variation of Tab &amp; Accordion based on viewport change

# How to build
To build the project, start your AEM instance & run the below maven command from the root directory of the project
```
mvn clean install -PautoInstallPackage 
```
From the bundle directory, run ``mvn -PautoInstallBundle clean install`` to build *just* the bundle and install to a CQ instance.

# Using with VLT
--------------

To use vlt with this project, first build and install the package to your local CQ instance as described above. Then cd to `content/src/main/content/jcr_root` and run

    vlt --credentials admin:admin checkout -f ../META-INF/vault/filter.xml --force http://localhost:4502/crx

Once the working copy is created, you can use the normal ``vlt up`` and ``vlt ci`` commands.

# Specifying CRX Host/Port
------------------------

The CRX host and port can be specified on the command line with:
``mvn -Dcrx.host=otherhost -Dcrx.port=5502 <goals>``