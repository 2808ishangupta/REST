# REST

The project is a Simple Demo application for a REST webservice providing few simple endpoint methods to provide data on BitCoin share prices.
More specifically currently it provides average data, and data for last X minutes in multiple currencies. However can be easily extended to many more data extractions.
Currently it uses externaly publically avaible apy from crytocomapre to fetch the json data and then wrap that data to a more specific shrinked information object.


To launch the application we just need to run the DemoApplication class which uses SpringBoot to run the application in its embedded tomcat.
base url:localhost:8080/bitcoindata



As per design details:

1. We have a BitCoindData which is a POJO to store the data relevant according to ur needs.
2. There is a BitCoinDataController which is basically the  component class having path mappings
3. There is BitCoinService which has the method implementations for the GET calls


With current implementations there are few assumptions:
1.The data currently taken from cryptocompare api are meant to change any time.
2.For more proper stable environment, data must be stored in a DB which must be used by the sevice class to populate the POJOs.
3. there is no web.xml file created, as spring boot is taking care of the mappings
4. NO front end for the applications, calls needs to be made after checking the mapping paths.
