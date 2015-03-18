# To deploy and run the application #

## Preliminaries ##

**Download and install the JOnAS application server from http://wiki.jonas.ow2.org/xwiki/bin/view/Main/WebHome** Launch a JOnAS instance
**Download the deployment plans of the [application](http://jonas-showcase.googlecode.com/files/jonas-showcase-1.0.0-deployment-plans.zip)**

## Deploy and Run ##

  * 1. Drop the repositories.xml file in the 'deploy' folder of your JOnAS instance
  * 2. Drop the shop.xml file in the 'deploy' folder of your JOnAS instance
  * 3. Open your browser to http://localhost:9000/showcase/coffee.html (no products are  provided by default)
  * 4. Deploy products by dropping products deployment plans into the 'deploy' folder
  * 5. Click on the 'update' button of the web page to update the list of available product

  * 6. If you remove products deployment plans, products will be withdrawn from the application.