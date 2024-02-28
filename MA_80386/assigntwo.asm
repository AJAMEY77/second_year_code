section .data
	var3 db "Enter the string",0ah
	var3_len equ $-var3
	
	
	
%macro Read 2
	mov rax, 0
	mov rdi, 0
	mov rsi, %1
	mov rdx, %2
	syscall
%endmacro


%macro print 2
	mov rax, 1
	mov rdi, 1
	mov rsi, %1
	mov rdx, %2
	syscall
%endmacro



%macro End 0
	mov rax, 60
	mov rdi, 0
	syscall
%endmacro

section .bss
	result resb 2
	num1 resb 20
	num1_len equ $-num1
	

section .text
	global _start
	
_start: 
	;mov rax, 50
	print var3,var3_len
	Read num1,num1_len
	dec rax
	call display_proc
	End

display_proc :
	mov rbx, 16
	mov rcx,2
	mov rsi, result+1
	
cnt : 	
	mov rdx, 0
	div rbx
	
	cmp dl, 09h
	jbe add30
	add dl, 07h
	
add30 : 
	add dl, 30h
	mov [rsi], dl	
	dec rsi
	dec rcx
	jnz cnt
	print result,2
	ret
	
	
