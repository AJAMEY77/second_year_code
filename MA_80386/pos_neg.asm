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


section .data
	p_msg db "Count of Positive Num : "
	p_msg_len equ $-p_msg
	
	nline db 10, 10
	nline_len equ $-nline
	
	n_msg db "Count of Negative Num : "
	n_msg_len equ $-n_msg
	
	arr dq 12h, -20h, -15h, 17h, -30h, 0h, -66h, 45h, 07h, 24h
	n equ 10

	
section .bss
	p_count resq 1
	n_count resq 1
	result resb 2
	
	
section .text
	global _start:
	
_start :
	mov rsi, arr
	mov rcx, n
	
	mov rbx, 0
	mov rdx, 0
	
next_num : 
	mov rax, [rsi]
	rol rax, 1
	jc negative
	
positive : 
	inc rbx
	jmp next
	
negative : 
	inc rdx
	
next : 
	add rsi, 8
	dec rcx
	jnz next_num
	
	mov [p_count], rbx 
	mov [n_count], rdx
	
	print p_msg, p_msg_len
	mov rax, [p_count]
	call display
	
	print nline, nline_len
	
	print n_msg, n_msg_len
	mov rax, [n_count]
	call display
	
	print nline, nline_len
	
	End
	



display :
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
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


