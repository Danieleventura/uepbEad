    function validarFormulario(){
        var email = document.forms["formLogin"]["email"].value;
        var senha = document.forms["formLogin"]["senha"].value;

        var perfil = document.getElementById("perfil");
        var valor = perfil.options[perfil.selectedIndex].value;
    
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
        
        //if (valor == "Professor") {

           // window.location ="/professor";   
            //alert("Dentro"); 

       // }if (valor == "Aluno") {

         //   window.location ="/aluno";   
            //alert("Dentro"); 

      //  }else{
           
      //      alert("fora"); 
      //  }
        
    }
    
    function criarUsuario(){
    	window.location ="/cadastro/usuario";   
    	
    }