package com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.controllers;



import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.javafx.iio.ImageStorage;


//import org.apache.tomcat.util.http.fileupload.FileUtils;

//import com.fasterxml.jackson.core.JsonParseException;

import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.domain.Response;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.exceptions.ResourceNotFoundException;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.Salle;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.models.User;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.MaterielRepository;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.SalleRepository;
import com.lawsonmorel.ServeurGestionReservationSallesMunicipalesUCAO.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalleController {
	
	@Autowired
	SalleRepository salleRepository;
	
	@Autowired
	MaterielRepository materielRepository;
	

	@Autowired
	UserRepository userRepository;

	
	@Autowired  ServletContext context;
	 @GetMapping("/users")
	  public List<User> getAllUser() {
	    System.out.println("Get all Utilisateur...");
	 
	    List<User> user = new ArrayList<>();
	    userRepository.findAll().forEach(user::add);
	 
	    return user;
	  }
	 @DeleteMapping("/users/delete")
	  public ResponseEntity<String> deleteAllUtilisateur() {
	    System.out.println("Delete All Utilisateur...");
	 
	    userRepository.deleteAll();
	 
	    return new ResponseEntity<>("All Utilisateurs have been deleted!", HttpStatus.OK);
	  }
	 

	 
	 @GetMapping("/Salle")
	  public List<Salle> getAllSalle() {
	     System.out.println("Get all salles...");
	 
	    List<Salle> salle = new ArrayList<>();
	    salleRepository.findAll().forEach(salle::add);
	 
	    return salle;
	  }
	 
	 @GetMapping ("/getAll")
	 public ResponseEntity<List<String>> getAll()
	 {
		 List<String> listSalle = new ArrayList<String>();
		 String filesPath = context.getRealPath("/Images");
		 File filefolder = new File(filesPath);
		 if (filefolder != null)
		 {
			for (File file :filefolder.listFiles())
			{
				if(!file.isDirectory())
				{
				  String encodeBase64 = null;
				  try {
					  String extension = FilenameUtils.getExtension(file.getName());
					  FileInputStream fileInputStream = new FileInputStream(file);
				      byte[] bytes = new byte[(int)file.length()];
				      fileInputStream.read(bytes);
				      encodeBase64 = Base64.getEncoder().encodeToString(bytes);
				      listSalle.add("data:image/"+extension+";base64,"+encodeBase64);
				      fileInputStream.close();
				      
				      
				  }catch (Exception e){
					  
				  }
				}
			}
		 }
		 return new ResponseEntity<List<String>>(listSalle,HttpStatus.OK);
	 }
	 
/*	 @PostMapping(value = "/ajouterSalle")
	 public ResponseEntity<Response> saveUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("user") String user) throws JsonParseException , JsonMappingException , Exception
	 {
       Salle salle = new ObjectMapper().readValue(user, Salle.class);
      
       salle.setFileName(file.getOriginalFilename());
       Salle sa = salleRepository.save(salle));
       
       
       	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
       }
       else
       {
       	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
       }
	 }
	 
	 */
	 
	    @PostMapping("/salles")
	 public ResponseEntity<Response> createSalle (@RequestParam("file") MultipartFile file,
			 @RequestParam("article") String article) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
       Salle salle = new ObjectMapper().readValue(article, Salle.class);
       boolean isExit = new File(context.getRealPath("/Images/")).exists();
       if (!isExit)
       {
       	new File (context.getRealPath("/Images/")).mkdir();
       	System.out.println("mk dir.............");
       }
       String filename = file.getOriginalFilename();
       String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
       File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
       try
       {
       	System.out.println("Image");
       	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
       	 
       }catch(Exception e) {
       	e.printStackTrace();
       }

      
       salle.setFileName(newFileName);
       Salle sa  = salleRepository.save(salle);
       if (sa != null)
       {
       	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
       }
       else
       {
       	return new ResponseEntity<Response>(new Response ("Salle non enrégistrée"),HttpStatus.BAD_REQUEST);	
       }
	 }
	 
	 
	 @GetMapping("/salles/{id}")
		public ResponseEntity<Salle> getSalleById(@PathVariable(value = "id") Long Id)
				throws ResourceNotFoundException {
			Salle salle = salleRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + Id));
			return ResponseEntity.ok().body(salle);
		}
	 
	 @GetMapping(path="/Imgsalles/{id}")
	 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
		Salle salle  = salleRepository.findById(id).get();
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+salle.getFileName()));
	 }
	
	
				

	@DeleteMapping("/salles/{id}")
	public Map<String, Boolean> deleteSalle(@PathVariable(value = "id") Long SalleId)
			throws ResourceNotFoundException {
		Salle salle = salleRepository.findById(SalleId)
				.orElseThrow(() -> new ResourceNotFoundException("Salle non trouvée id :: " + SalleId));
		salleRepository.delete(salle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  	 
	@DeleteMapping("/salles/delete")
	  public ResponseEntity<String> deleteAllarticles() {
	    System.out.println("Delete All salles...");
	    salleRepository.deleteAll();
	    return new ResponseEntity<>("All salles have been deleted!", HttpStatus.OK);
	}

	  @PutMapping("/salles/{id}")
	  public ResponseEntity<Salle> updateSalle(@PathVariable("id") long id, @RequestBody Salle salle) {
	    System.out.println("Update Salle with ID = " + id + "...");
	    Optional<Salle> salleInfo = salleRepository.findById(id);
	    if (salleInfo.isPresent()) {
	    	Salle sal = salleInfo.get();
	           sal.setId(salle.getId());
	           sal.setNom(salle.getNom());
	           sal.setEtat(salle.getEtat());
	           sal.setAdresse(salle.getAdresse());
	           sal.setCapaciteMin(salle.getCapaciteMin());
	           sal.setCapaciteMax(salle.getCapaciteMax());
	           sal.setDescription(salle.getDescription());
	           sal.setPrixAsso(salle.getPrixAsso());
	           sal.setPrixParticulier(salle.getPrixParticulier());
	         
	           
	      return new ResponseEntity<>(salleRepository.save(salle), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
