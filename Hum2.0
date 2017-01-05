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

/* No momento necessario atribuir essa parte de codigo do departamento como sendo o 
departamento inteiro em si.*/

int ValidarData(int dia,int mes,int ano){	
	if((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12) && (ano >= 1900 && ano <= 2100)){
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

void excluirdep(){
	
}


//PARTE DOS FUNCIONARIOS
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
			printf("Codigo e Nome dos Departamentos q existe: \n");
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
	printf("Funcionário cadastrado com sucesso!\n");
	printf("\n");
	i++;

	printf("%d\n",i);
	printf("\n");
}

void alterar(){
	int resp,fun,cargo,cont;
	char resp2;
	
	printf("Digite o numero do funcionario que deseja alterar: ");
	scanf(" %d", &fun);
	printf("Deseja alterar:\n");
	printf("1 - Nome\n2 - CPF\n3 - Data de Nascimento\n4 - Data de Admissao\n5 - Cargo\n0 - Sair\n");
	scanf(" %d", &resp);
	
	while(resp != 0){
		while((resp2 != 's') || (resp2 != 'S')){
			switch(resp){
				case 1:
				   	printf("Antigo NOME: %s\n", func[fun].nome);
				   	printf("Digite o novo nome: ");
				   	scanf(" %s", func[fun].nome);
				   	printf("Novo NOME: %s\n", func[fun].nome);
				   	break;
				case 2:
				   	printf("Antigo CPF: %s\n", func[fun].cpf);
				   	printf("Digite o novo CPF: ");
					scanf(" %s", func[fun].cpf);
				   	printf("Novo CPF: %s\n", func[fun].cpf);
				   	break;
				case 3:
					printf("Antiga Data de Nascimento: %d %d %d\n", func[fun].dt_nasc.dia,func[fun].dt_nasc.mes,func[fun].dt_nasc.ano);
					printf("Digite a nova data(DD MM AA): ");
					scanf("%d %d %d", &func[fun].dt_nasc.dia,&func[fun].dt_nasc.mes,&func[fun].dt_nasc.ano);
					printf("Nova Data de Nascimento: %d %d %d\n", func[fun].dt_nasc.dia,func[fun].dt_nasc.mes,func[fun].dt_nasc.ano);
					break;
				case 4:
					printf("Antiga Data de Admissao: %d %d %d\n", func[fun].dt_adm.dia,func[fun].dt_adm.mes,func[fun].dt_adm.ano);
					printf("Digite a nova data(DD MM AA): ");
					scanf("%d %d %d", &func[fun].dt_adm.dia,&func[fun].dt_adm.mes,&func[fun].dt_adm.ano);
					printf("Nova Data de Admissao: %d %d %d\n", func[fun].dt_adm.dia,func[fun].dt_adm.mes,func[fun].dt_adm.ano);
					break;  
				case 5:
				   	printf("Antigo Cargo: %d\n", func[fun].cargo);
				   	printf("Digite o novo cargo: ");
				   	scanf(" %d", &cargo);
				   	func[fun].cargo = cargo;
				   	printf("Novo Cargo: %d\n", func[fun].cargo);
				   	break;
				default:
				   	printf("Try again\n");
				   	break;
		  	}
		  	printf("Deseja continuar alterando os dados desse funcionario <s/n>: ");
        	scanf(" %c", &resp2);
        	if((resp2 == 'S') || (resp2 == 's')){
				printf("1 - Nome\n2 - CPF\n3 - Data de Nascimento\n4 - Data de Admissao\n5 - Cargo\n0 - Sair\n");
	    		scanf(" %d", &resp);
			}
			else{
				cont = 1;
			}
			if(cont==1){
				break;
			}
		}
		printf("Digite o numero do funcionario que deseja alterar(para sair digite um numero negativo): ");
		scanf(" %d", &fun);
		if(fun < 0){
			break;
		}
		printf("Deseja alterar:\n");
		printf("1 - Nome\n2 - CPF\n5 - Cargo\n0 - Sair\n");
		scanf(" %d", &resp);
	}
}

void transferir(){
	printf("O usuario foi transferido\n");
}

void demitir(){
	printf("O funcionario foi demitido\n");
}

void consulta(){
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


//PARTE DOS MENUS
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

void menufunc(){
	int resp;
	printf("MENU FUNCIONARIO\n");
	printf("===============\n1 - Cadastrar\n2 - Alterar\n3 - Transferir\n4 - Demitir\n5 - Listar todos os Funcionarios\n6 - Listar todos de um Departamento\n7 - Consulta\n0 - Sair\n===============\n");
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
	   			break;
	   		case 6:
	   			break;
	   		case 7:
	   			consulta();
	   			break;
			default:
				printf("Nop,para de tentar achar bug ai,vlw\n");
				break;
		};
	   	printf("===============\n1 - Cadastrar\n2 - Alterar\n3 - Transferir\n4 - Demitir\n5 - Listar todos os Funcionarios\n6 - Listar todos de um Departamento\n7 - Consulta\n0 - Sair\n===============\n");
		scanf("%d", &resp);
	}
}

void menurel(){
	int resp;
	printf("MENU RELATORIO\n");
	printf("===============\n1 - Departamento\n2 - Funcionario\n0 - Sair\n===============\n");
	scanf(" %d", &resp);
	while(resp != 0){
		switch(resp){
			case 0:
				printf("Programa finalizado\n");
				break;
			case 1:
				menudep();
				break;
			case 2:
				menufunc();
				break;
			default:
				printf("Nop,para de tentar achar bug ai,vlw\n");
				break;
		};
		printf("MENU RELATORIO\n");
	   	printf("===============\n1 - Departamento\n2 - Funcionario\n0 - Sair\n===============\n");
		scanf(" %d", &resp);
	}
}

int main(){
	menurel();
	return 0;
};
