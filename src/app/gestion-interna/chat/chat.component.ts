import { usuarioConversacion } from 'src/app/general/clases/usuario';
import { TokenService } from './../../general/servicios/token.service';
import { ActivatedRoute, Router } from '@angular/router';
import { historialMensajes, mensaje, MensajeConSide } from './../../general/clases/chat-message';
import { ChatService } from './../../general/servicios/chat.service';
import { ChangeDetectorRef, Component, ElementRef, OnInit } from '@angular/core';
 
@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messageInput: string='';
  userId:string='';
  messageList: MensajeConSide[]=[];
  room:string='';
  yaMensajes:Boolean=false;

  constructor(
    private ChatService: ChatService,
    private route:ActivatedRoute,
    private TokenService:TokenService,
    private router: Router
  ) { 
    this.ChatService.initConnectionSocket();
  }

  ngOnInit() {
    
    this.room= this.ChatService.getIdConversacion();
    this.userId=this.route.snapshot.params["userId"];
    this.ChatService.joinRoom(this.room);
    this.listenerMessage();
  }

  sendMessage(){
    const mensaje:mensaje={
      descripcionMensaje:this.messageInput,
      idUsuarioMensaje:this.userId,
      idConversacion:this.room
    }
    this.ChatService.sendMessage(this.room,mensaje);
    this.messageInput='';
  }


 listenerMessage(){
    const idConversacion:number= Number(this.room);
    this.ChatService.getMessageSubject(idConversacion).subscribe((messages:mensaje[])=>{
      console.log("el objeto de listener trae: ");
      console.log(messages);


      this.messageList=messages.map((item:any)=> ({
        ...item,
        message_side: item.idUsuarioMensaje === this.TokenService.getUserName() ? 'sender': 'receiver'   
      }));
      this.yaMensajes=true;
    })
    
  }


  regresar(){
    this.router.navigate(['gestion-interna/conversaciones']);
  }

}


