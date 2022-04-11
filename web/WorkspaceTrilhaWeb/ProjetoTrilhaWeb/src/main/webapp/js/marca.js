COLDIGO.marca = new Object();

$(document).ready(function() {
	
	//Requisição para realizar busca de marcas
	COLDIGO.marca.buscar = function() {

		var valorBuscaMarca = $("#campoBuscaMarca").val();

		$.ajax({
			type: "GET",
			url: COLDIGO.PATH + "marca/buscarMarca",
			data: "valorBuscaMarca=" + valorBuscaMarca,
			success: function(dados) {

				$("#listaMarcas").html(COLDIGO.marca.exibir(dados));

			},
			error: function(info) {
				COLDIGO.exibirAviso("Erro ao consultar as marcas: " + info.status + " - " + info.statusText);
			}
		});
	};

	//Requisição para cadastrar uma marca
	COLDIGO.marca.cadastrar = function() {

		var marca = new Object();
		marca.nome = document.frmAddMarca.nome.value;

		if (marca.nome == "") {
			COLDIGO.exibirAviso("Preencha o nome da marca!");
		} else {
			$.ajax({
				type: "POST",
				url: COLDIGO.PATH + "marca/inserir",
				data: JSON.stringify(marca),
				success: function(msg) {
					COLDIGO.exibirAviso(msg);
					$("#addMarca").trigger("reset");
					
				},
				error: function(info) {
					COLDIGO.exibirAviso("Erro ao cadastrar uma nova marca: " + info.status + " - " + info.statusText);
				}
			});
			COLDIGO.marca.buscar();
		}
	};

	//Função para construir uma tabela com a lista de marcas
	COLDIGO.marca.exibir = function(listaDeMarcas) {

		var tabela = "<table>" +
			"<tr>" +
			"<th>Categoria</th>" +
			"<th class='acoes'>Ações</th>" +
			"</tr>";

		if (listaDeMarcas != undefined && listaDeMarcas.length > 0) {

			for (var i = 0; i < listaDeMarcas.length; i++) {
				tabela += "<tr>" +
					"<td>" + listaDeMarcas[i].nome + "</td>" +
					"<td>" +
					"<a onclick=\"COLDIGO.marca.exibirEdicao('" + listaDeMarcas[i].id + "')\"><img src='../../imgs/edit.png' alt='Editar registro'></a>" +
					"<a onclick=\"COLDIGO.marca.verificaExclusao('" + listaDeMarcas[i].id + "')\"><img src='../../imgs/delete.png' alt='Excluir registro'</a>" +
					"</td>" +
					"</tr>"
			}
		} else if (listaDeMarcas == "") {
			tabela += "<tr><td colspan='6'>Nenhum registro encontrado</td></tr>";
		}
		tabela += "</table>";

		return tabela;
	}

	COLDIGO.marca.buscar();

	//Função que exibe a modal com os dados da marca a ser editada
	COLDIGO.marca.exibirEdicao = function(id) {
		$.ajax({
			type: "GET",
			url: COLDIGO.PATH + "marca/buscarPorId",
			data: "id=" + id,
			success: function(marca) {

				document.frmEditaMarca.idMarca.value = marca.id;
				document.frmEditaMarca.nome.value = marca.nome;

				var modalEditaMarca = {
					title: "Editar Marca",
					height: 400,
					width: 550,
					modal: true,
					buttons: {
						"Salvar": function() {
							COLDIGO.marca.editar();
						},
						"Cancelar": function() {
							$(this).dialog("close");
						}
					},
					close: function() {

					}
				};

				$("#modalEditaMarca").dialog(modalEditaMarca);
			}
		});
	}
	
	//Função que excuta a edição da marca de fato
	COLDIGO.marca.editar = function() {
		var marca = new Object();
		marca.id = document.frmEditaMarca.idMarca.value;
		marca.nome = document.frmEditaMarca.nome.value;

		$.ajax({
			type: "PUT",
			url: COLDIGO.PATH + "marca/alterar",
			data: JSON.stringify(marca),
			success: function(msg) {
				COLDIGO.exibirAviso(msg);
				COLDIGO.marca.buscar();
				$("#modalEditaMarca").dialog("close");
			},
			error: function(info) {
				COLDIGO.exibirAviso("Erro ao editar marca: " + info.status + " - " + info.statusText);
			}
		});
	};

	//Verifica se o usuário quer realmente excluir a marca
	COLDIGO.marca.verificaExclusao = function(id) {
		var aviso = "Deseja realmente excluir esta marca?";
		var modalExclusao = {
			title: "Mensagem",
			heigth: 250,
			width: 400,
			modal: true,
			buttons: {
				"OK": function() {
					COLDIGO.marca.excluir(id);
				},
				"Cancelar": function() {
					$(this).dialog("close");
				}
			}
		};
		$("#modalAviso").html(aviso);
		$("#modalAviso").dialog(modalExclusao);
	}
	
	//Função que exclui a marca de fato
	COLDIGO.marca.excluir = function(id) {
		$.ajax({
			type: "DELETE",
			url: COLDIGO.PATH + "marca/excluir/" + id,
			success: function(msg) {
				COLDIGO.exibirAviso(msg);
				COLDIGO.marca.buscar();
				
			},
			error: function(info) {
				COLDIGO.exibirAviso("Erro ao excluir marca: " + info.status + " - " + info.statusText);
			}
		})
	}
});