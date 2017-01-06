#include <stdio.h>
#include <string.h>
#define F 3

int i=0;

typedef struct{
	int dia,mes,ano;	
}tdata;

typedef struct{
	char cpf[12];
	char nome[100];
	tdata dt_adm;
	tdata dt_nasc;
	int cargo;
	int dept;
}tFuncionario;

typedef struct{
	char nome[100];
	int cod;
	int quant; // Contador de funcionarios dentro do departamento
}tDepartamento;

tFuncionario func[F];
int prox[F];
int controle[2][11];
tDepartamento dep[10];


/* Necessario tbm criar uma variavel q conte os departamentos ja cadastrados 
Duvidas que permanecem: ordem de onde starta as porra, onde inserir a porra desses
prox e controle, acho tbm q o unico define necessario eh o de funcionario.*/

/* Aparenta-se tbm q primeiro ira ser feito registro dos departamentos para depois
vir a dos funcionarios. */

/* No momento, O CODIGO DO DEPARTAMENTO ESTA SENDO IGUAL AO NUMERO CORRESPONDENTE DE 
DEPARTAMENTO, CODIGO 1 == DEPARTAMENTO 1, NUM SEI SE É PRA FICAR ASSIM, MAS NO MOMENTO
ESTA.*/


/*
Objetivo: verificar se uma data eh valida.
Parâmetros: dia, mes, ano.
Retorno: 1 se for data valida ou 0 se nao. 
*/

//NO FINAL, AJEITAR O ANO.
int ValidarData(int dia,int mes,int ano){	
	if((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12) && (ano >= 00 && ano <= 99)){
		if(ano % 4 == 0 && (ano % 400 == 0 || ano % 100 != 0)){ 
			if(dia == 29 && mes == 2){
				return 1;
			}
		}
        if(dia <= 28 && mes == 2){
        	return 1;
		}
		if(dia >= 30 && mes == 2){
			return 0;
		}
        if((dia <= 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11)){
            return 1;
		} 
        if((dia <=31) && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes ==8 || mes == 10 || mes == 12)){
            return 1;
		}
        else{
        	return 0;
		}
    }
    else{
    	return 0;
	}
}

//PARTE DOS DEPARTAMENTOS

//Objetivo: Criar Departamento.
void criardep(){ 
	int cod,i,cont=0,x,resp;

	while(resp!=0){
		printf("Qual o codigo do Departamento? ");
		scanf(" %d", &cod);
		for(i=0;i<10;i++){
		    if(cod == dep[i].cod){
				cont++;
			}
		}
		if(cont>0){
			printf("Departamento %d ja existe!\n", cod);
			cont=0;
			printf("---------------\n0 - Para retornar ao Menu Departamento\n1 - Digitar um novo codigo\n---------------\n");
			scanf("%d", &resp);
			if(resp==0)
				return;
		}
		else{
			x = cod-1;
			dep[x].cod = cod;
			printf("Qual o nome do Departamento? ");
			scanf(" %s", dep[x].nome);
			printf("Departamento de Codigo %d e Nome %s criado com sucesso\n", dep[x].cod,dep[x].nome);
			printf("---------------\n0 - Para retornar ao Menu Departamento\n1 - Digitar um novo codigo\n---------------\n");
			scanf("%d", &resp);
			if(resp==0)
				return;
		}			
	}
}

//Objetivo: Alterar informaçoes do Departamento.
void alterardep(){ 
	int resp,i=0,cont=0,resp2;
	while(resp2!=0){
		printf("Qual o codigo do Departamento? ");
		scanf(" %d", &resp);
		for(i=0;i<F;i++){
			if(resp == dep[i].cod){
				cont++;
			}
		}
		if(cont==0){
			printf("Departamento %d nao existe!\n", resp);
			printf("---------------\n0 - Para retornar ao Menu Departamento\n1 - Digitar um novo codigo\n---------------\n");
			scanf("%d", &resp2);
			if(resp2==0)
				return;
		}
		else{
			printf("Antigo nome do Departamento %d: %s\n", resp,dep[resp-1].nome);
			printf("Qual o novo nome do Departamento: ");
			scanf(" %s", dep[resp-1].nome);
			printf("Departamento de Codigo %d e o seu Novo Nome eh: %s, foi alterado com sucesso\n", dep[resp-1].cod,dep[resp-1].nome);
			printf("---------------\n0 - Para retornar ao Menu Departamento\n1 - Digitar um novo codigo\n---------------\n");
			scanf("%d", &resp2);
			if(resp2==0)
				return;
		}
	}
}

//Objetivo: Consultar Departamento.
void consultardep(){
	int resp,cont=0,i;
	printf("Qual o codigo do Departamento? ");
	scanf(" %d", &resp);
	for(i=0;i<F;i++){
		if(resp == dep[i].cod){
			cont++;
		}
	}
	if(cont==0){
		printf("Departamento %d nao existe!\n", resp);
		return;
	}
	else{
		printf("Nome do Departamento %d: %s\n", resp,dep[resp-1].nome);
		printf("Quantidade de funcionarios dentro do Departamento: %d\n", dep[resp-1].quant);
	}
}

//Objetivo: Listar as informaçoes dos Departamentos criados.
void listardep(){
	int j,cont=0;
	for(j=0;j<10;j++){
		if(dep[j].cod==0){
			cont++;
			if(cont==10){
				printf("Nao ha Departamentos cadastrados.\n");
			}
		}
		else{
			printf("Departamento %d - Codigo: %d\n", j+1,dep[j].cod);
			printf("Departamento %d - Nome: %s\n", j+1,dep[j].nome);
			printf("Departamento %d - Quantidade de Funcionarios: %d\n", j+1,dep[j].quant);
			printf("\n");
		}
	}
}

//Objetivo: Excluir Departamentos.
void excluirdep(){
	
}


//PARTE DOS FUNCIONARIOS

//Objetivo: Cadastrar um novo funcionario.
void cadastrar(){
	char cpf[12];
	int a,j,x,y,z,resp=0,cont=1,cont2=0,resp2;
	
	while(resp!=2){
		printf("Qual o cpf?: ");
   		scanf(" %s", cpf);
		for(j=0;j<F;j++){
			a = strcmp(cpf,func[j].cpf);
			if(a==0){
				cont = 0;
			}
		}
		if(cont==0){
			printf("CPF %s ja cadastrado!\n", cpf);
			cont = 1;
			printf("---------------\n0 - Voltar ao Menu Funcionario\n1 - Digitar um novo cpf\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			strcpy(func[i].cpf,cpf);
			resp = 2;
		}
	}
	printf("Qual o nome?: ");
	scanf(" %s", func[i].nome);
	printf("Qual a data de nascimento?: ");
	scanf("%d %d %d", &func[i].dt_nasc.dia,&func[i].dt_nasc.mes,&func[i].dt_nasc.ano);
	x = ValidarData(func[i].dt_nasc.dia,func[i].dt_nasc.mes,func[i].dt_nasc.ano);
	while(x==0){
		if(x==0){
			printf("Data Invalida! Digite novamente: ");
			scanf("%d %d %d", &func[i].dt_nasc.dia,&func[i].dt_nasc.mes,&func[i].dt_nasc.ano);
			x = ValidarData(func[i].dt_nasc.dia,func[i].dt_nasc.mes,func[i].dt_nasc.ano);
		}
		else{
			break;
		}
	}
	printf("Qual a data de admissão na empresa?: ");
	scanf("%d %d %d", &func[i].dt_adm.dia,&func[i].dt_adm.mes,&func[i].dt_adm.ano);
	y = ValidarData(func[i].dt_adm.dia,func[i].dt_adm.mes,func[i].dt_adm.ano);
	while(y==0){
		if(y==0){
			printf("Data Invalida! Digite novamente: ");
			scanf("%d %d %d", &func[i].dt_adm.dia,&func[i].dt_adm.mes,&func[i].dt_adm.ano);
			y = ValidarData(func[i].dt_adm.dia,func[i].dt_adm.mes,func[i].dt_adm.ano);
		}
		else{
			break;
		}
	}
	printf("Qual o cargo?: ");
	scanf(" %d", &func[i].cargo);
	while(resp2!=0){
		printf("Qual o departamento?: ");
	   	scanf(" %d", &func[i].dept);
	   	cont2 = 0;
		for(j=0;j<10;j++){
			if(dep[j].cod == func[i].dept){
				cont2++;
			}
		}
		if(cont2 == 0){
			printf("Departamento %d nao existe!\n", func[i].dept);
			printf("Codigo e Nome dos Departamentos q existem: \n");
			for(j=0;j<10;j++){
				printf("Code: %d, Nome: %s\n", dep[j].cod,dep[j].nome);
			}
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar um novo codigo\n---------------\n");
			scanf(" %d", &resp2);
			if(resp2==0)
				return;
		}	   	
		else{
			z = func[i].dept - 1;
			dep[z].quant++;
			break;
		}	   
	}
	printf("Funcionario cadastrado com sucesso!\n");
	i++;

	printf("%d\n",i);
	printf("\n");
}

//Objetivo: Alterar informaçoes de um funcionario.
void alterar(){ 
	char cpf[12],cpf2[12];
	int j,a,cont=0,x,resp,resp2,resp3,cont2,b,c;
	
	// Se a == 0, entao cpf == func[j].cpf
	while(resp!=2){
		printf("Qual o CPF do funcionario?: ");
   		scanf(" %s", cpf);
		for(j=0;j<F;j++){
			a = strcmp(func[j].cpf,cpf);
			if(a==0){
				cont++;
				x = j;
			}
		}
		if(cont==0){
			printf("CPF %s nao cadastrado!\n", cpf);
			printf("---------------\n0 - Voltar ao Menu Funcionario\n1 - Digitar um novo cpf\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			printf("MENU ALTERAR FUNCIONARIO(CPF: %s)\n", cpf);
			printf("1 - CPF\n2 - Nome\n3 - Data de Nascimento\n4 - Data de Admissao na empresa\n5 - Cargo\n0 - Sair\n");
			scanf(" %d", &resp2);
			
			while(resp2!=0){
				switch(resp2){
					case 0:
						break;
					case 1:
						while(resp3!=2){
							//vvvvvv EXCLUIR NO FINAL.
							printf("Antigo CPF: %s\n", func[x].cpf);
				   			printf("Qual o novo cpf?: ");
				   			scanf(" %s", cpf2);
							for(j=0;j<F;j++){
								a = strcmp(func[j].cpf,cpf2);
								if(a==0){
									cont2=0;
								}
							}
							if(cont2==0){
								printf("CPF %s ja cadastrado!\n", cpf2);
								printf("---------------\n0 - Voltar ao Menu Alterar Funcionario\n1 - Digitar um novo cpf\n---------------\n");
								scanf(" %d", &resp3);
								if(resp3==0)
									break;
							}
							else{
								strcpy(func[x].cpf,cpf2);
								printf("CPF alterado com sucesso!\n");			   		
				   				break;
							}		   			
					   	}
					   	break;
					case 2:
						//vvvvvv EXCLUIR NO FINAL.
						printf("Antigo NOME: %s\n", func[x].nome);
				   		printf("Qual o novo nome?: ");
				   		scanf(" %s", func[x].nome);
				   		printf("Nome alterado com sucesso!\n");
						printf("Novo NOME: %s\n", func[x].nome); // EXCLUIR NO FINAL.
				   		break;
					case 3:
						//vvvvvv EXCLUIR NO FINAL.
						printf("Antiga Data de Nascimento: %d %d %d\n", func[x].dt_nasc.dia,func[x].dt_nasc.mes,func[x].dt_nasc.ano);
						printf("Qual o novo ano de nascimento?(DD MM AA): ");
						scanf("%d %d %d", &func[x].dt_nasc.dia,&func[x].dt_nasc.mes,&func[x].dt_nasc.ano);
						b = ValidarData(func[x].dt_nasc.dia,func[x].dt_nasc.mes,func[x].dt_nasc.ano);	
						while(b==0){
							if(b==0){
								printf("Data Invalida! Digite novamente: ");
								scanf("%d %d %d", &func[x].dt_nasc.dia,&func[x].dt_nasc.mes,&func[x].dt_nasc.ano);
								b = ValidarData(func[x].dt_nasc.dia,func[x].dt_nasc.mes,func[x].dt_nasc.ano);
							}
							else{
								break;
							}
						}
						printf("Data de nascimento alterada com sucesso!\n");
						printf("Nova Data de Nascimento: %d %d %d\n", func[x].dt_nasc.dia,func[x].dt_nasc.mes,func[x].dt_nasc.ano);
						//^^^^^^ EXCLUIR NO FINAL.
						break;
					case 4:
						//vvvvvv EXCLUIR NO FINAL.
						printf("Antiga Data de Admissao: %d %d %d\n", func[x].dt_adm.dia,func[x].dt_adm.mes,func[x].dt_adm.ano);
						printf("Digite a nova data(DD MM AA): ");
						scanf("%d %d %d", &func[x].dt_adm.dia,&func[x].dt_adm.mes,&func[x].dt_adm.ano);
						c = ValidarData(func[x].dt_adm.dia,func[x].dt_adm.mes,func[x].dt_adm.ano);
						while(c==0){
							if(c==0){
								printf("Data Invalida! Digite novamente: ");
								scanf("%d %d %d", &func[x].dt_adm.dia,&func[x].dt_adm.mes,&func[x].dt_adm.ano);
								c = ValidarData(func[x].dt_adm.dia,func[x].dt_adm.mes,func[x].dt_adm.ano);
							}
							else{
								break;
							}
						}
						printf("Data de admissão alterada com sucesso!\n");
						printf("Nova Data de Admissao: %d %d %d\n", func[x].dt_adm.dia,func[x].dt_adm.mes,func[x].dt_adm.ano);
						//^^^^^^ EXCLUIR NO FINAL.
						break;
					case 5:
						//vvvvvv EXCLUIR NO FINAL.
				   		printf("Antigo Cargo: %d\n", func[x].cargo);
				   		printf("Qual o novo cargo?: ");
				   		scanf(" %d", &func[x].cargo);
				   		printf("Cargo alterado com sucesso!\n");
				   		printf("Novo Cargo: %d\n", func[x].cargo);
				   		//^^^^^^ EXCLUIR NO FINAL.
				   	   	break;
					default:
				   		printf("Try again\n");
				   		break;
				}
				printf("MENU ALTERAR FUNCIONARIO(CPF: %s)\n", cpf);
				printf("1 - CPF\n2 - Nome\n3 - Data de Nascimento\n4 - Data de Admissao na empresa\n5 - Cargo\n0 - Sair\n");
				scanf(" %d", &resp2);
			}
			printf("Saiu\n");
			//^^^^^^ EXCLUIR NO FINAL.
			break;
		}
	}
}

//Objetivo: Transferir um funcionario para outro departamento.
void transferir(){
	int resp,cod,j,cont=0,x,y,z,a,cod2;
	char cpf[12];
	
	while(resp!=2){
		printf("Qual o codigo do departamento origem?: ");
		scanf(" %d", &cod);
		for(j=0;j<10;j++){
			if(dep[j].cod == cod){
				cont++;
				x = j+1;	
			}			
		}
		if(cont==0){
			printf("Departamento %d nao existe!\n", cod);
			printf("Codigo e Nome dos Departamentos q existem: \n");
			for(j=0;j<10;j++){
				printf("Code: %d, Nome: %s\n", dep[j].cod,dep[j].nome);
			}
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar um novo codigo de departamento\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			printf("Quantidade de func. dentro do departamento q perdera gente: %d\n", dep[x-1].quant);//EXCLUIR FINAL
			break;
		}
	}
	resp = 3;
	cont = 0;
	while(resp!=2){
		printf("Qual o cpf do funcionario?: ");
		scanf(" %s", cpf);
		for(j=0;j<10;j++){
			if(func[j].dept==x){
				a = strcmp(func[j].cpf,cpf);
				if (a==0){
					cont++;
					y = j;
				}	
			}
		}
		if(cont==0){
			printf("Departamento %d nao possui funcionario com o cpf %s!\n", x,cpf);
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar outro cpf\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			printf("Antigo Departamento: %d\n", func[y].dept); //EXCLUIR NO FINAL
			break;
		}
	}
	resp = 3;
	cont = 0;
	while(resp!=2){
		printf("Qual o codigo do departamento destino?: ");
		scanf(" %d", &cod2);
		for(j=0;j<10;j++){
			if(dep[j].cod == cod2){
				cont++;
			}			
		}
		if(cont==0){
			printf("Departamento %d nao existe!\n", cod2);
			printf("Codigo e Nome dos Departamentos q existem: \n");
			for(j=0;j<10;j++){
				printf("Code: %d, Nome: %s\n", dep[j].cod,dep[j].nome);
			}
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar um novo codigo de departamento\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			func[y].dept = cod2;
			printf("Novo Departamento: %d\n", func[y].dept);
			dep[x-1].quant = dep[x-1].quant - 1;
			for(j=0;j<10;j++){
				if(dep[j].cod == cod2){
					dep[j].quant++;
					z = j;
				}
			}
			printf("Transferencia realizada com sucesso!\n");
			printf("Quantidade de funcioarios no departamento q perdeu gente: %d\n", dep[x-1].quant); //EXCLUIR FINAL
			printf("Quantidade de func. no departamento q ganhou gente: %d\n", dep[z].quant);//EXCLUIR FINAL
			break;
		}
	}
}

//Objetivo: Demitir um funcionario.
void demitir(){
	int resp,j,cod,cont=0,x,a;
	char cpf[12],resp2;
	
	while(resp!=2){
		printf("Qual o codigo do departamento?: ");
		scanf(" %d", &cod);
		for(j=0;j<10;j++){
			if(dep[j].cod == cod){
				cont++;
				x = j+1;	
			}			
		}
		if(cont==0){
			printf("Departamento %d nao existe!\n", cod);
			printf("Codigo e Nome dos Departamentos q existem: \n");
			for(j=0;j<10;j++){
				printf("Code: %d, Nome: %s\n", dep[j].cod,dep[j].nome);
			}
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar um novo codigo de departamento\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			break;
		}
	}
	resp = 3;
	cont = 0;
	while(resp!=2){
		printf("Qual o cpf?: ");
		scanf(" %s", cpf);
		for(j=0;j<10;j++){
			if(func[j].dept==x){
				a = strcmp(func[j].cpf,cpf);
				if (a==0){
					cont++;
				}	
			}
		}
		if(cont==0){
			printf("Departamento %d nao possui funcionario com o cpf %s!\n", x,cpf);
			printf("---------------\n0 - Para retornar ao Menu Funcionario\n1 - Digitar outro cpf\n---------------\n");
			scanf(" %d", &resp);
			if(resp==0)
				return;
		}
		else{
			break;
		}
	}
	while((resp2!='s') || (resp2!='n')){
		printf("Deseja realmente demitir o funcionario? <s/n>: ");
		scanf(" %c", &resp2);
		if(resp2=='n'){
			printf("Funcionario não demitido!\n");
			return;
		}
		if(resp2=='s'){
			for(j=0;j<F;j++){
				a = strcmp(func[j].cpf,cpf);
				if (a==0){
					strcpy(func[j+1].cpf,func[j].cpf);
					strcpy(func[j+1].nome,func[j].nome);
					func[j].dt_nasc = func[j+1].dt_nasc;
					func[j].dt_adm = func[j+1].dt_adm;
					func[j].cargo = func[j+1].cargo;
					func[j].dept = func[j+1].dept;
				}
			}
			dep[x-1].quant = dep[x-1].quant - 1;
			printf("Funcionario demitido com sucesso!\n");
			break;
		}
	}	
}

//Objetivo: Mostrar a informaçoes de um funcionario especifico.
void pesquisar(){
	char cpf[12];
	int a,j;
	printf("Digite o cpf do funcionario: ");
	scanf(" %s", cpf);
	for(j=0;j<=i;j++){
		a = strcmp(cpf,func[j].cpf);
		if (a==0)
			printf("Nome do funcionario: %s\n",func[j].nome);
	}
}

void listarfunc(){
	int j;
	printf("LISTA DE FUNCIONARIOS\n");
	for(j=0;j<10;j++){
		printf("--------------------\nDepartamento)
	}
}

//PARTE DOS MENUS

//Objetivo: acesso as configuraçoes de Funcionarios.
void menufunc(){
	int resp;
	printf("MENU FUNCIONARIO\n");
	printf("===============\n1 - Cadastrar funcionario\n2 - Alterar dados do funcionario\n3 - Transferir funcionario de departamento\n4 - Demitir funcionario\n5 - Pesquisar funcionario\n6 - Listar todos os funcionarios\n7 - Listar todos de um Departamento\n0 - Sair\n===============\n");
	scanf("%d", &resp);
	while(resp != 0){
		switch(resp){
			case 0:
				printf("Programa finalizado\n");
				break;
			case 1:
				cadastrar();
				break;
			case 2:
				alterar();
				break;	
   			case 3:
	   			transferir();
	   			break;
	   		case 4:
	   			demitir();
	   			break;
	   		case 5:
	   			pesquisar();
	   			break;
	   		case 6:
	   			listarfunc();
	   			break;
	   		case 7:
	   			break;
			default:
				printf("Nop,para de tentar achar bug ai,vlw\n");
				break;
		};
		printf("===============\n1 - Cadastrar funcionario\n2 - Alterar dados do funcionario\n3 - Transferir funcionario de departamento\n4 - Demitir funcionario\n5 - Pesquisar funcionario\n6 - Listar todos os funcionarios\n7 - Listar todos de um Departamento\n0 - Sair\n===============\n");
		scanf("%d", &resp);
	}
}

//Objetivo: acesso as configuraçoes de Departamentos.
void menudep(){
	int resp;
	printf("MENU DEPARTAMENTO\n");
	printf("===============\n1 - Criar Departamento\n2 - Alterar nome do Departamento\n3 - Consultar Departamento\n4 - Listar Departamentos\n5 - Excluir Departamento\n0 - Sair\n===============\n");
	scanf("%d", &resp);
		while(resp != 0){
			switch(resp){
				case 0:
					printf("Programa finalizado\n");
					break;
				case 1:
					criardep();
					break;
				case 2:
					alterardep();
					break;	
    			case 3:
    				consultardep();
		   			break;
		   		case 4:
		   			listardep();
		   			break;
		   		case 5:
		   			excluirdep();
		   			break;
				default:
					printf("Nop,para de tentar achar bug ai,vlw\n");
					break;
			};
			printf("===============\n1 - Criar Departamento\n2 - Alterar nome do Departamento\n3 - Consultar Departamento\n4 - Listar Departamentos\n5 - Excluir Departamento\n0 - Sair\n===============\n");
			scanf("%d", &resp);
		}
}

//Objetivo: acessar os menus departamento e funcionario.
void menuprin(){
	int resp;
	printf("MENU PRINCIPAL\n");
	printf("===============\n1 - Funcionario\n2 - Departamento\n0 - Sair\n===============\n");
	scanf(" %d", &resp);
	while(resp != 0){
		switch(resp){
			case 0:
				printf("Programa finalizado\n");
				break;
			case 1:
				menufunc();
				break;
			case 2:
				menudep();
				break;
			default:
				printf("Nop,para de tentar achar bug ai,vlw\n");
				break;
		};
		printf("MENU PRINCIPAL\n");
	   	printf("===============\n1 - Funcionario\n2 - Departamento\n0 - Sair\n===============\n");
		scanf(" %d", &resp);
	}
}

int main(){
	menuprin();
	return 0;
}; 
