import java.util.Scanner;

public class RTO1SEM8RCC {
    public static void main(String[] args) {
     String[][] nombres=new String[3][3]; //cambie el [2][3] por [3][3] por simplicidad a la hora de leer datos
     int[][] vida=new int[2][3];   
     int[][] ataque= new int[2][3];
     int[][] magia=new int[2][3];
     int[][] energia=new int[2][3];
     int[][] cura=new int[2][3];
     Boolean[][] vivo= new Boolean[2][3];
     Boolean pjvivos1=true;
     Boolean pjvivos2=true;
     int vidatrue1=0;
     int vidatrue2=0;
     int turno=0;
     Scanner lr=new Scanner(System.in);
      System.out.println("Player 1");
      System.out.println("ingresa tus heroes");
      for (int i = 0; i < nombres.length; i++){
        System.out.println("heroe "+(i+1)+": ");
        nombres[0][i]=lr.nextLine();
        System.out.println("vida de tu heroe "+(i+1)+":");
        vida[0][i]=lr.nextInt();
        while(vida[0][1]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            vida[0][i]=lr.nextInt();
            lr.nextLine();
        }
        System.out.println("ataque de tu heroe "+(i+1)+":");
        ataque[0][i]=lr.nextInt();
        while(ataque[0][1]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            ataque[0][i]=lr.nextInt();
            lr.nextLine();
        }
        System.out.println("magia de tu heroe "+(i+1)+":");
        magia[0][i]=lr.nextInt();
        while(magia[0][1]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            magia[0][i]=lr.nextInt();
            lr.nextLine();
        }
        vivo[0][i]=true;
        lr.nextLine();
      }
      System.out.println("Player 2");
      System.out.println("ingresa tus heroes");
      for(int I=0;I< nombres.length;I++){
        System.out.println("heroe "+(I+1)+": ");
        nombres[1][I]=lr.nextLine();
        while(nombres[1][I].isEmpty()){
            System.out.println("valor no valido, ingrese de nuevo");
            nombres[1][I]=lr.nextLine();
        }
        System.out.println("vida de tu heroe "+(I+1)+":");
        vida[1][I]=lr.nextInt();
        while(vida[1][I]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            vida[1][I]=lr.nextInt();
            lr.nextLine();
        }
        System.out.println("ataque de tu heroe "+(I+1)+":");
        ataque[1][I]=lr.nextInt();
        while(ataque[1][I]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            ataque[1][I]=lr.nextInt();
            lr.nextLine();
        }
        System.out.println("magia de tu heroe "+(I+1)+":");
        magia[1][I]=lr.nextInt();
        while(magia[1][I]<0){
            System.out.println("valor no valido, ingrese de nuevo");
            magia[1][I]=lr.nextInt();
            lr.nextLine();
        }
        vivo[1][I]=true;
        lr.nextLine();
      }
      for(int e=0;e<nombres.length;e++){
        energia[0][e]=1000;
        energia[1][e]=1000;
      }
     while(pjvivos1 && pjvivos2){
        //eleccion de player 1
         System.out.println("player 1");
        System.out.println("elige un heroe:");
         String Heroname1=lr.nextLine();
        for(int i=0;i<nombres.length;i++){
            if(Heroname1.equals(nombres[0][i])){
                if(vida[0][i]>0){
                System.out.println("Seleccionado");
                vidatrue1=vida[0][i];
                break;
                    }else{
                        while (!Heroname1.equals(nombres[0][i])){
                        System.out.println("heroe muerto seleccione otro");
                        Heroname1=lr.nextLine();
                        for(i=0;i<nombres.length;i++){
                            if(Heroname1.equals(nombres[0][i])){
                                if(vida[0][i]>0){
                                    System.out.println("Seleccionado");
                                    vidatrue1=vida[0][i];
                                    break;
                                }
                            }
                        }
                    }
                }  
                }else{
                    while(!Heroname1.equals(nombres[0][i])){
                        System.out.println("Nombre no valido, ingrese de nuevo");
                        for(i=0;i<nombres.length;i++){
                        Heroname1=lr.nextLine();
                            if(Heroname1.equals(nombres[0][i])){
                            vidatrue1=vida[0][i];
                            break;
                           }
                        }
                    }
                }
            }
            
            //eleccion de player 2
            System.out.println("player 2");
        System.out.println("elige un heroe:");
         String Heroname2=lr.nextLine();
        for(int i=0;i<nombres.length;i++){
            if(Heroname2.equals(nombres[1][i])){
                if(vida[1][i]>0){
                System.out.println("Seleccionado");
                vidatrue2=vida[1][i];
                break;
                    }else{
                        while (!Heroname2.equals(nombres[1][i])){
                        System.out.println("heroe muerto seleccione otro");
                        Heroname2=lr.nextLine();
                        for(i=0;i<nombres.length;i++){
                            if(Heroname2.equals(nombres[1][i])){
                                if(vida[1][i]>0){
                                    System.out.println("Seleccionado");
                                    vidatrue2=vida[1][i];
                                    break;
                                }
                            }
                        }
                    }
                }  
                }else{
                    while(!Heroname2.equals(nombres[1][i])){
                        System.out.println("Nombre no valido, ingrese de nuevo");
                        for(i=0;i<nombres.length;i++){
                        Heroname2=lr.nextLine();
                            if(Heroname2.equals(nombres[1][i])){
                            vidatrue2=vida[1][i];
                            break;
                           }
                        }
                    }
                }
            }
            //Menu de acciones
            if (turno>1){
                turno=0;
            }
            if(turno==0){
                System.out.println("-------player 1-------");
            }else{
                System.out.println("-------player 2-------");
            }
            System.out.println("1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. curarse");
            System.out.println("4. cambiar heroe");
            int accion=lr.nextInt();
            switch (accion) {
                //ataque
                case 1:
                    if(turno==0){
                    for(int i=0;i<nombres.length;i++){
            if(Heroname1.equals(nombres[0][i])){
                for(int I=0;I<nombres.length;I++){
                    if(Heroname2.equals(nombres[1][I])){
                        vida[1][I]=ataque[0][i]-vida[1][I];
                        System.out.println(Heroname1+" ha apuñalado a "+Heroname2);
                        System.out.println("Vida de "+Heroname2+" a bajado a "+vida[1][I]);
                        turno++;
                        break;
                        }    
                    }
                }
            }
            }else{
              for(int i=0;i<nombres.length;i++){
                if(Heroname2.equals(nombres[1][i])){
                    for(int I=0;I<nombres.length;I++){
                        if(Heroname1.equals(nombres[0][I])){
                        vida[0][I]=ataque[1][i]-vida[0][I];
                        System.out.println(Heroname2+" ha apuñalado a "+Heroname1);
                        System.out.println("Vida de "+Heroname1+" a bajado a "+vida[0][I]);
                        turno++;
                        break;
                        }
                    }
                }
            }   
        } break;
        //ataque de magia
        case 2:
            if(turno==0){
                for(int i=0;i<nombres.length;i++){
                    if(Heroname1.equals(nombres[0][i])){
                        if(!(energia[0][i]<=0)){
                        for(int I=0;I<nombres.length;I++){
                            if(Heroname2.equals(nombres[1][I])){
                                vida[1][I]=magia[0][i]-vida[1][I];
                                System.out.println(Heroname1+" ha embestido con su energia maldita a "+Heroname2);
                        System.out.println("Vida de "+Heroname2+" a bajado a "+vida[1][I]);
                                energia[0][i]-=250;
                                turno++;
                                break;
                            }
                        }
                    }else{
                        System.out.println("energia insuficiente");
                        turno++;
                        break;
                    }
                    }
                }
            }else{
                   for(int i=0;i<nombres.length;i++){
                    if(Heroname2.equals(nombres[1][i])){
                        if(!(energia[1][i]<=0)){
                        for(int I=0;I<nombres.length;I++){
                            if(Heroname1.equals(nombres[0][I])){
                                vida[0][I]=magia[1][i]-vida[0][I];
                                System.out.println(Heroname2+" ha embestido con su energia maldita a "+Heroname1);
                        System.out.println("Vida de "+Heroname1+" a bajado a "+vida[0][I]);
                                energia[1][i]-=250;
                                turno++;
                                break;
                            }
                        }
                    }else{
                        System.out.println("energia insuficiente");
                        turno++;
                        break;
                    }
                    }
                }
            }break;
            //curarse
            case 3:
            if(turno==0){
                for(int i=0;i<nombres.length;i++){
                    if(Heroname1.equals(nombres[0][i])){
                        if(cura[0][i]<3){
                            cura[0][i]+=1;
                            vida[0][i]=vida[0][i]+50;
                            if(vida[0][i]>vidatrue1){
                                vida[0][i]=vidatrue1;
                            }else{
                                System.out.println("ya realizaste tus 2 curaciones :(");
                                turno++;
                                break;
                            }
                        }
                        System.out.println("curacion exitosa");
                        turno++;
                        break;
                    }
                }
            }else{
                   for(int i=0;i<nombres.length;i++){
                    if(Heroname2.equals(nombres[1][i])){
                        if(cura[1][i]<3){
                            cura[1][i]+=1;
                            vida[1][i]=vida[0][i]+50;
                            if(vida[1][i]>vidatrue2){
                                vida[1][i]=vidatrue2;
                            }else{
                                System.out.println("ya realizaste tus 2 curaciones :(");
                                turno++;
                                break;
                            }
                        }
                        System.out.println("curacion exitosa");
                        turno++;
                        break;
                        }
                    }
                }break;
                case 4:
                     //eleccion de heroe
                     if(turno==0){
        System.out.println("player 1");
        System.out.println("elige un heroe:");
          Heroname1=lr.nextLine();
        for(int i=0;i<nombres.length;i++){
            if(Heroname1.equals(nombres[0][i])){
                if(vida[0][i]>0){
                System.out.println("Seleccionado");
                vidatrue1=vida[0][i];
                turno++;
                break;
                    }else{
                        while (!Heroname1.equals(nombres[0][i])){
                        System.out.println("heroe muerto seleccione otro");
                        Heroname1=lr.nextLine();
                        for(i=0;i<nombres.length;i++){
                            if(Heroname1.equals(nombres[0][i])){
                                if(vida[0][i]>0){
                                    System.out.println("Seleccionado");
                                    vidatrue1=vida[0][i];
                                    turno++;
                                    break;
                                }
                            }
                        }
                    }
                }  
                }else{
                    while(!Heroname1.equals(nombres[0][i])){
                        System.out.println("Nombre no valido, ingrese de nuevo");
                        for(i=0;i<nombres.length;i++){
                        Heroname1=lr.nextLine();
                            if(Heroname1.equals(nombres[0][i])){
                            vidatrue1=vida[0][i];
                            turno++;
                            break;
                           }
                        }
                    }
                }
            }
        }else{
            System.out.println("player 2");
        System.out.println("elige un heroe:");
          Heroname2=lr.nextLine();
        for(int i=0;i<nombres.length;i++){
            if(Heroname2.equals(nombres[1][i])){
                if(vida[1][i]>0){
                System.out.println("Seleccionado");
                vidatrue2=vida[1][i];
                turno++;
                break;
                    }else{
                        while (!Heroname2.equals(nombres[1][i])){
                        System.out.println("heroe muerto seleccione otro");
                        Heroname2=lr.nextLine();
                        for(i=0;i<nombres.length;i++){
                            if(Heroname2.equals(nombres[1][i])){
                                if(vida[1][i]>0){
                                    System.out.println("Seleccionado");
                                    vidatrue2=vida[1][i];
                                    turno++;
                                    break;
                                }
                            }
                        }
                    }
                }  
                }else{
                    while(!Heroname2.equals(nombres[1][i])){
                        System.out.println("Nombre no valido, ingrese de nuevo");
                        for(i=0;i<nombres.length;i++){
                        Heroname2=lr.nextLine();
                            if(Heroname2.equals(nombres[1][i])){
                            vidatrue2=vida[1][i];
                            turno++;
                            break;
                                        }
                                    }
                                }
                            }
                        }    
                    }break;        
                }    
             //verificacion de vida por ciclo
        if(!(vida[0][0]>0 || vida[0][1]>0 || vida[0][2]>0)){
        pjvivos1=false;
     }
        if(!(vida[1][0]>0 || vida[1][1]>0 || vida[1][2]>0)){
        pjvivos2=false;
                 }
            }
            if((vida[0][0]>0 || vida[0][1]>0 || vida[0][2]>0)){
        System.out.println("felicidades player 1 has ganado!");
     }else{
        System.out.println("felicidades player 2 has ganado!");
     }
        }
    }
