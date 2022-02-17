    function validarFormulario(){
    	
        var email = document.forms["formLogin"]["email"].value;
        var senha = document.forms["formLogin"]["senha"].value;

        
        if((email == "") && (senha == "")){
        	alert("Usuário inválido");
        	return false;
        }else{          
        
		        if (email == "" ) {
		            document.getElementById('email').focus();
		            alert("Preencha todos os campos");                     
		            return false;
		        }
		
		        if (senha == "") {
		                document.getElementById('senha').focus();
		                alert("Preencha todos os campos");                  
		                return false;  
		        }
		      
        }
              
    }
    
    
    function criarUsuario(){
    	window.location ="/cadastro/usuario";   
    	
    }