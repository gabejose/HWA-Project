Coverage: 70.2 %

Due to making Selenium tests and SpringBoot tests separate from each other, I calculated the average coverage to make up for the mistake by getting the total coverage from Selenium and SpringBoot. The coverage from the Selenium tests is at 98.3 % (refer to screenshots page or presentation slides as evidence). 

# HWA-Project

This project is a basic web application that simulates an inventory system that holds the details of rowing clubs in the UK and the different kinds of boats these rowing clubs have (ranging from small boats such as singles (1x) and doubles (2x)/pairs (2-) to bigger boats such as coxless fours (4-) and eights (8+)). This also includes the different companies that make these boats, such as Empacher, Filippi Boats and Hudson Boat Works. For the boat clubs, the details showed on the web page are its name, address, its 3 letter identifier (as issued by British Rowing) and the name of the head coach. For the boats themselves, the details showed are its type (2-, 4+, 8+, etc), its company make (e.g. Empacher Bootswerft), the average crew weight (measured in kg), the material of the riggers (aluminium or carbon), whether the riggers are wing riggers or not and the ID of the boat club that they belong to (referring to the generated ID of the boat club in SQL). 

## Getting Started
This project includes a far .jar file which will allow you to start the program from the terminal. I included a method in the application that outputs a message saying "Spring is working" (for my convenience when testing) as well as the timestamp for when you start running the program. From there, you should be able to open the index.html page (open the front end folder in VS code and open the live server). 
Due to unprecedented issues with Git and Internet speeds, the proper Selenium testing (which is fully functional) is stored in the folder "SELENIUM V2". The other Selenium folder is very much broken. Additionally, the Selenium stuff should've been together with the SpringBoot, so consequently there are two fat .jar files to run from the command line (apologies for inconvenience caused).

## Prerequisites
The following software is required in order for the project to run:
* Eclipse IDE (Download from https://www.eclipse.org/downloads/) for Java

* MySQL 8.0 (Download from https://www.mysql.com/downloads/) for SQL

* Visual Studio Code (Download from https://code.visualstudio.com/download) for HTML, CSS and JavaScript

* Postman (Download from https://www.postman.com/downloads/) for testing fetch requests from API

* SpringBoot (can be downloaded through Eclipse in the marketplace) for setting up the web application and to test/communicate with the backend

* Selenium (downloaded through Google Chrome) for testing the front end

## Installing

Refer to pre - requisites section for links to download the necessary software

## Running the program
Open the HWAFrontEnd folder in VS code and turn on the live server when opening index.html. Then from the command line, you can run the .jar files. This is done by
```
mvn clean package
java -jar (project-name)-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

## Unit Tests
Unit tests allow each .java file (e.g. boat.java) to test each method without relying on the other classes to see if they work on their own before being deployed. For test coverage, it should only cover the methods within that class (i.e. coverage in all other classes besides boat.java should be 0%). Here is an example:
```
@RunWith(MockitoJUnitRunner.class)
public class BoatServiceUnitTest {

	@InjectMocks
	private BoatService service;
	
	@Mock
	private BoatRepo repo;
	
	@Mock
	private BoatClub club;
	
	@Test
	public void createBoatTest() {
		Boat input = new Boat("8+", "Empacher", 95, "Carbon", true, club);
		Boat output = new Boat(1L, "8+", "Empacher", 95, "Carbon", true, club);
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.createBoat(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
    
    // <code for rest of CRUD below>

```
Mock objects for BoatService, BoatRepo and BoatClub are created in order to ensure that the test will run properly without having to rely on the actual objects.

## Integration Tests
Unlike the unit tests, integration tests test the class as well as any other classes that it may rely on to run. This helps the testing for when the code is actually running to see if it works correctly. Below is an example of an integration test in the project:
```
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BoatClubControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createBoatClubTest() throws Exception {
		BoatClub input = new BoatClub("London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String inputAsJSON = this.mapper.writeValueAsString(input);
		RequestBuilder request = post("/boatclub/create").contentType(MediaType.APPLICATION_JSON).content(inputAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		BoatClub inputSaved = new BoatClub(1L, "London Rowing Club", "123 Anystreet Putney Embankment SW10 9HF", "LRC", "Stuart", "Heap");
		String inputSavedAsJSON = this.mapper.writeValueAsString(inputSaved);
		
		ResultMatcher checkBody = content().json(inputSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
    
    // <code for rest of CRUD tests below>

```

## Coding style

Before each method, add a comment using // and briefly describe what the method does, specify what the parameter(s) and return type(s) is (if applicable). This is to ensure that for shared projects, the other person can understand what each method does and makes debugging easier.

```
// Comment saying what the method does
// @param if the method has any parameters
// @return if the method has a return type (not needed if return
// type is void)
public <return type> <method name>() {
    <code goes here>
}
```

## Built With
Maven - Dependecy Management

## Versioning
We use SemVer for versioning

## Author
* **Gabriel Jose** - *Initial work* - [gabejose](https://github.com/gabejose)

## Acknowledgments
* Rowing is a hobby, such that it takes up at least 50% of my life. As much as it pushes me to have annual meetings with death, I still enjoy the sport very much
* YouTube for the funny and interesting rowing content
