%macro print 2
	mov eax, 1
	mov edi, 1
	mov esi, %1
	mov edx, %2
	syscall
%endmacro

%macro End 0
	mov eax, 60
	mov edi, 0
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
	p_count resd 1
	n_count resd 1
	result resd 2
	
	
section .text
	global _start:
	
_start :
	mov esi, arr
	mov ecx, n
	
	mov ebx, 0
	mov edx, 0
	
next_num : 
	mov eax, [rsi]
	rol eax, 1
	jc negative
	
positive : 
	inc ebx
	jmp next
	
negative : 
	inc edx
	
next : 
	add rsi, 8
	dec rcx
	jnz next_num
	
	mov [p_count], ebx 
	mov [n_count], edx
	
	print p_msg, p_msg_len
	mov eax, [p_count]
	call display
	
	print nline, nline_len
	
	print n_msg, n_msg_len
	mov eax, [n_count]
	call display
	
	print nline, nline_len
	
	End
	



display :
	mov ebx, 16
	mov ecx,2
	mov esi, result+1
	
cnt : 	
	mov edx, 0
	div ebx
	
	cmp dl, 09h
	jbe add30
	add dl, 07h
	
add30 : 
	add dl, 30h
	mov [esi], dl	
	dec esi
	dec ecx
	jnz cnt
	print result,2
	ret
	 
	
	
	
