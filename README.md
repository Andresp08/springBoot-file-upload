# SpringBoot File Upload

`Swagger Documentation`

![file upload success](https://github.com/Andresp08/springBoot-file-upload/assets/45151760/f1ecd288-3b75-4f25-8a31-0e0ccb470d84)

## Upload files with springboot using opencsv

## If you want to use this generic file upload without the anotation @CsvBindByName, you can replace the GenericCsvParseToEntity methods for:

    public Set<Entity> parseCsvToEntity(MultipartFile file, Class<Entity> entityClass) throws IOException,  
    CsvValidationException {  
	    Set<Entity> entities = new HashSet<>();  
      
		    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {  
			    String[] header = reader.readNext();  
			    String[] line;  
			      
			    while ((line = reader.readNext()) != null) {  
			    Entity entity = buildEntity(header, line, entityClass);  
			    entities.add(entity);  
		    }  
	    }    
	    return entities;  
    }  
      
    private Entity buildEntity(String[] header, String[] line, Class<Entity> entityClass) {  
	    try {  
		    Entity entity = entityClass.getDeclaredConstructor().newInstance();  
		      
		    for (int i = 0; i < header.length; i++) {  
		    String columnName = header[i];  
		    String cellValue = line[i];  
		      
		    Field field = entityClass.getDeclaredField(columnName);  
		    field.setAccessible(true);  
		      
		    if (field.getType() == String.class) {  
			    field.set(entity, cellValue);  
		    } else if (field.getType() == int.class) {  
			    field.set(entity, Integer.parseInt(cellValue));  
		    }    
		    field.setAccessible(false);  
	    }  
	    return entity;  
	    } catch (Exception e) {  
		    throw new RuntimeException("Error al construir entidad", e);  
	    }  
	 }
