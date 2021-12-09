function buttonDisabled() {
	document.getElementById('envio').disabled = true;
}

function buttonEnabled(){
	if(document.getElementById('assinatura').checked == true){
		document.getElementById('envio').disabled = false;
	}else{
		document.getElementById('envio').disabled = true;
	}
}

function validaSubscribe(){
	if(document.frmsubscribe.txtnome.value == ""){
		alert("Preencha o campo Nome.");
		document.frmsubscribe.txtnome.focus();
		return false;
	}
	
	var cpf = document.frmsubscribe.cpf.value;
	var expRegCpf = new RegExp("^[0-9]{3}[.]{1}[0-9]{3}[.]{1}[0-9]{3}[-]{1}[0-9]{2}$")
	
	if(!expRegCpf.test(cpf)){
		alert("Preencha o campo CPF corretamente.")
		document.frmsubscribe.cpf.focus();
		return false;
	}
	
	if(document.frmsubscribe.sexo.value == ""){
		alert("Preencha o campo Sexo.");
		return false;
	}
	if(document.frmsubscribe.fone.value == ""){
		alert("Preencha o campo Telefone.");
		document.frmsubscribe.fone.focus();
		return false;
	}
	
	var email = document.frmsubscribe.email.value;
	var expRegEmail = new RegExp("^[a-z]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}$");
	
	if(!expRegEmail.test(email)){
		alert("Preencha o campo E-mail corretamente.");
		document.frmsubscribe.email.focus();
		return false;
	}
	
}

$(document).ready(function() {
	$("header").load("/AppleFanClub/pages/site/general/cabecalho.html");
	$("nav").load("/AppleFanClub/pages/site/general/menu.html");
	$("footer").load("/AppleFanClub/pages/site/general/rodape.html");
})