The **JOnAS Showcase** illustrates how JEE & OSGi can **seamlessly** interact thanks to JOnAS.It shows how a JEE applications can be extended dynamically thanks to OSGi.

This project is an example of the offered possibilities such as how EJBs can use OSGi services and how EJBs can provide OSGi services.

For further information about this showcase, please read this [blog entry](http://blog.akquinet.de/2009/07/27/jonas-showcase-having-the-best-of-jee-and-osgi/).

# Context #
Since a couple of years, two different types of enterprise application development are "emerging":
  * Java Platform, Enterprise Edition or Java EE is a widely used platform for server programming in the Java programming language. The Java platform (Enterprise Edition) differs from the Java Standard Edition Platform (Java SE) in that it adds libraries which provide functionality to deploy fault-tolerant, distributed, multi-tier Java software, based largely on components running on an application server.
  * The OSGi framework is a module system for Java that implements a complete and dynamic component model, something that does not exist in standalone Java/VM environments. Applications or components (coming in the form of bundles for deployment) can be remotely installed, started, stopped, updated and uninstalled without requiring a reboot; management of Java packages/classes is specified in great detail. Life cycle management is done via APIs which allow for remote downloading of management policies. The service registry allows bundles to detect the addition of new services, or the removal of services, and adapt accordingly.

Nowadays, a stringent problematic is to reunify those two worlds. Despite a large dominance of JEE to develop enterprise applications, the OSGi wave is "menacing" the JEE hegemony. There are several reasons for this menace. First, OSGi modularity system is clean, tailored, powerful and promotes good practices. Using OSGi generally improves the product "quality". Moreover, the hot-deployment and the dynamism support of OSGi is interesting for enterprise applications.

# Dunkin' JOnAS #
This showcase (Dunkin' JOnAS) is a simple shop. It illustrates how JEE applications can be extended with OSGi services. This is not intended to be used directly, it just illustrates OSGi / JEE interactions inside JOnAS.

![http://jonas-showcase.googlecode.com/svn/resources/shop.png](http://jonas-showcase.googlecode.com/svn/resources/shop.png)

# About Us #
akquinet AG is a high-performance IT consulting company for standard solutions, customized development, and outsourcing - operating internationally and has been a long-serving and active participant In the Open Source movement.

Taking Java, OSGi, JEE, SAP, and Microsoft as a basis, akquinet advises with respect to processes and industry in the selection, implementation, and optimization of IT solutions. Working agilely, akquinet develops customized software and integrates existing system environments as well as operating customer systems securely and reliably in high-performance computer centers.

For more information, please visit our [website](http://www.akquinet.de/en/javasap/java-products/modular-solutions.html).