section .data
	msg_1 db "Hello World", 0ah
	msg_len_1 equ $-msg_1,
	msg_2 db "Hello Amey", 0ah,
	msg_len_2 equ $-msg_2,
	

section .text
	global _start
	
_start: 
	mov rax, 1
	mov rdi, 1
	mov rsi, msg_1
	mov rdx, msg_len_1
	syscall
	mov rax, 1
	mov rdi, 1
	mov rsi, msg_2
	mov rdx, msg_len_2
	syscall
	mov rax, 60
	mov rdi, 0
	syscall

