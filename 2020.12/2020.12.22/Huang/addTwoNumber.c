#include <stdlib.h>

struct ListNode{
	int val;
	struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1,struct ListNode* l2){
	struct ListNode* temp1 = l1;
	struct ListNode* temp2 = l2;
	struct ListNode *head = NULL,*tail = NULL;
	int celui_ci,n1,n2;
	int precedent = 0;
	
	while (temp1 || temp2){
		if (temp1 == NULL) n1 = 0; else n1 = temp1->val;
		if (temp2 == NULL) n2 = 0; else n2 = temp2->val;
		if (n1 + n2 + precedent >= 10){
			celui_ci = n1 + n2 + precedent - 10;
			precedent = 1;
		}else{
			celui_ci = n1 + n2 + precedent;
			precedent = 0;
		}
		
		if (head){
			tail->next = malloc(sizeof(struct ListNode));
			(tail->next)->val = celui_ci;
			(tail->next)->next = NULL;
			tail = tail->next;
		}else{
			head = tail = malloc(sizeof(struct ListNode));
			tail->val = celui_ci;
			tail->next =NULL;
		}
		
		if (temp1) temp1 = temp1->next;
		if (temp2) temp2 = temp2->next;
		}
	if (precedent > 0){
		tail->next = malloc(sizeof(struct ListNode));
		(tail->next)->val = precedent;
		(tail->next)->next = NULL;
	}
	
	return head;
}

