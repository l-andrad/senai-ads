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
	if(document.frmsubscribe.sexo.value == ""){
		alert("Preencha o campo Sexo.");
		return false;
	}
}