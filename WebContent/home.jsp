<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD ENDERECOS</title>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
</head>
<body>
	<script>

		var contextPath = window.location.href;
		
        $(document).ready(function() {

			$('#numero').keyup(function(){
				this.value = this.value.replace(/\D/g,'');
			});
                 	
        	 $('#ConfirmaAdicionarLink').click(function(){
        		 adicionarAlterarEndereco();
           	 });

        	 $('#buscaCep').click(function(){
        		 listarEnderecos(); 
           	 });

        	 listarEnderecos();         

        });

        function selecionarEndereco(row){

            var tds = $(row).find('td');

            $("#id").val($(tds[0]).text());
            $("#rua").val($(tds[1]).text());
            $("#numero").val($(tds[2]).text());
            $("#bairro").val($(tds[3]).text());
            $("#complemento").val($(tds[4]).text());
            $("#cidade").val($(tds[5]).text());
            $("#cep").val($(tds[6]).text());
            $("#estado").val($(tds[7]).text());
            
        }


        function adicionarAlterarEndereco(){

        	var url = contextPath+'services/endereco/save';
			var type = 'PUT';
        	
        	if($("#id").val() != ''){
        		url = contextPath+'services/endereco/update';
        		type = 'POST';
            }

        	var endereco = new Object();

        	endereco = {  
        			id 			: $("#id").val(),
                    rua 		: $("#rua").val(),
                    numero 		: $("#numero").val(),
                    bairro 		: $("#bairro").val(),
                    complemento : $("#complemento").val(),
                    cidade 		: $("#cidade").val(),
                    cep 		: $("#cep").val(),
                    estado 		: $("#estado").val(),
                 };

        	$.ajax({
        	    type: type,
        	    contentType: "application/json; charset=utf-8",
        	    url: url,
        	    data: JSON.stringify(endereco),
        	    dataType: "json",
        	    success: function (data) {
        	    	limparCampos();
        	    	listarEnderecos();   	        	
        	    },
        	    error: function (errorObj,status,errorThrown){

        	    	if(errorObj.responseText != ''){
            	        var errorMsg = $.parseJSON(errorObj.responseText);

            	        var errors = errorMsg.error.split(';');

            	        var msgs = '';
            	        $.each(errors,function(index,erro){
    						msgs += erro +'\n';
                    	});
            	       
            	        alert(msgs);
                	}else{
						alert('erro inesperado');
                   	}

        	    }
        	});
        	
        }

        function deletarEndereco(row){

            var tds = $(row).find('td');
        	var url = contextPath+'services/endereco/delete?id='+$(tds[0]).text();
			var type = 'DELETE';
        	

        	$.ajax({
        	    type: type,
        	    contentType: "application/json; charset=utf-8",
        	    url: url,
        	    dataType: "json",
        	    success: function (data) {
        	    	$(row).remove();
        	    	limparCampos();
        	    //	listarEnderecos();   	        	
        	    },
        	    error: function (errorObj){
        	    	if(errorObj.responseText != ''){
            	        var errorMsg = $.parseJSON(errorObj.responseText);

            	        var errors = errorMsg.error.split(';');

            	        var msgs = '';
            	        $.each(errors,function(index,erro){
    						msgs += erro +'\n';
                    	});
            	       
            	        alert(msgs);
                	}else{
						alert('erro inesperado');
                   	}
        	    }
        	});
        	
        }

        
       	function listarEnderecos(){
           	
       		$("#tableEnderecos").find("tr:gt(0)").remove();
       		var url = contextPath+'services/endereco/list';
        	var data = new Object();
        	var type = 'GET';

        	if($('#cepBusca').val() != ''){
        		url = contextPath+'services/endereco/findByCep';

        		data = {  cep 	: $('#cepBusca').val()   };
        		type = 'POST';
            }
        	
        	$.ajax({
        	    type: type,
        	    contentType: "application/json; charset=utf-8",
        	    url: url,
        	    data: JSON.stringify(data),
        	    dataType: "json",
        	    success: function (data) {

              	  if(data != null){

            	      
           	          var items = [];
      	        	  $.each( data, function( key, val ) {

      	  	        	if(val.length){
    	  	  	        	$.each(val,function(index,endereco){	
    		  	        			 var linha =  	"<tr id='row"+index+"'>"+
    						  	        			"<td>" + endereco.id + "</td>"+
    						  	  	        		"<td>" + endereco.rua + "</td>"+
    						  	        			"<td>" + endereco.numero + "</td>" +
    						  	        			"<td>" + endereco.bairro + "</td>"+
    						  	        			"<td>" + endereco.complemento + "</td>"+
    						  	        			"<td>" + endereco.cidade + "</td>" +
    						  	        			"<td>" + endereco.cep + "</td>"+
    						  	        			"<td>" + endereco.estado + "</td>"+
    						  	        			"<td><a href='#' onclick='selecionarEndereco(row"+index+")' >Alterar </a></td>" +
    						  	        			"<td><a href='#' onclick='deletarEndereco(row"+index+")' >Deletar</a></td>" +       			
    						  	        			"</tr>";
    	
    		  	        			items.push(linha);
    		  	  	  	    });
      	  	  	        }else{  	  	  	        
     	        			var linha =  	"<tr id='row0'>"+
      	        			"<td>" + val.id + "</td>"+
      	  	        		"<td>" + val.rua + "</td>"+
      	        			"<td>" + val.numero + "</td>" +
      	        			"<td>" + val.bairro + "</td>"+
      	        			"<td>" + val.complemento + "</td>"+
      	        			"<td>" + val.cidade + "</td>" +
      	        			"<td>" + val.cep + "</td>"+
      	        			"<td>" + val.estado + "</td>"+
      	        			"<td><a href='#' onclick='selecionarEndereco(row0)' >Alterar </a></td>" +
      	        			"<td><a href='#' onclick='deletarEndereco(row0)' >Deletar</a></td>" +       			
      	        			"</tr>";

    						items.push(linha);
      	  	        		 
      	  	  	  	    }
     	        	   
     	        	  });
     	        	 
     	        	  $("#tableEnderecos tbody").append(items);
                  }
 	        	
        	    },
        	    error: function (errorObj){
        	    	if(errorObj.responseText != ''){
            	        var errorMsg = $.parseJSON(errorObj.responseText);

            	        var errors = errorMsg.error.split(';');

            	        var msgs = '';
            	        $.each(errors,function(index,erro){
    						msgs += erro +'\n';
                    	});
            	       
            	        alert(msgs);
                	}else{
						alert('erro inesperado');
                   	}
        	    }
        	});
        }

        function limparCampos(){

            $("#id").val('');
            $("#rua").val('');
            $("#numero").val('');
            $("#complemento").val('');
            $("#bairro").val('');
            $("#cidade").val('');
            $("#cep").val('');
            $("#estado").val('');
        }
    </script>
    
    <center>
    <h1> CRUD ENDERECOS</h1><br/>

    <div>
        <h3>Adicionar Endereco</h3>
    	<table border="1" id="tableAdicionar">
        <thead>
            <tr>
                <th>Id</th>
                <th>Rua</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Complemento</th>
                <th>Cidade</th>
                <th>CEP</th>
                <th>Estado</th>
                <th>Acao</th>
            </tr>
        </thead>
        <tbody>
        	 <tr>
        	 	<td><input type="text" id="id" disabled="disabled" /> </td>
        	 	<td><input type="text" id="rua"/> </td>
        	 	<td><input type="text" id="numero" maxlength="10"/> </td>
        	 	<td><input type="text" id="bairro"/> </td>
        	 	<td><input type="text" id="complemento"/> </td>
        	 	<td><input type="text" id="cidade"/> </td>
        	 	<td><input type="text" id="cep"/> </td>
        	 	<td><input type="text" id="estado"/> </td>
        	 	<td><input type="button" id="ConfirmaAdicionarLink" value="Adicionar/Alterar"></td>
        	 </tr>
        </tbody>
    </table>
    </div>
    
    <div>
    	
    	<div>
	        <h3>Bucar Endereco</h3>
	    	<table border="0" id="tableBusca">
		        <thead>
		            <tr>
		                <th>CEP</th>
		            </tr>
		        </thead>
		        <tbody>
		        	 <tr>
		        	 	<td><input type="text" id="cepBusca"/> </td>
		        	 	<td style="border: 0"><input type="button" id="buscaCep" value="Buscar Endereco" /></td>
		        	 </tr>
		        </tbody>
		    </table>
	    </div>
	    
	    <h3> TABELA ENDERECOS</h3>
    <table border="1" id="tableEnderecos">
        <thead>
            <tr>
                <th>Id</th>
                <th>Rua</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Complemento</th>
                <th>Cidade</th>
                <th>CEP</th>
                <th>Estado</th>
                <th colspan=2>Acao</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    </div>
    </center>
    
</body>
</html>