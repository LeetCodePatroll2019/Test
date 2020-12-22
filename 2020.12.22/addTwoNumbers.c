#include <stdlib.h>

typedef struct ListNode_{
	int val;
	struct ListNode *suivant;
}ListNode;

void ajouteNum(ListNode* l,int val){
	ListNode* final;
	final = (ListNode*)malloc(sizeof(ListNode));
	final->val = val;
	final->suivant = NULL;
	 
	if (l == NULL){		
		l = final;
	}else{
		ListNode* temp = l;
		while (temp->suivant != NULL){
			temp = temp->suivant;
		}
		temp->suivant = final;
	}
}

ListNode* addTwoNumbers(ListNode* l1,ListNode* l2){
	ListNode* temp1 = l1;
	ListNode* temp2 = l2;
	ListNode* res = NULL;
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
		
		ajouteNum(res,celui_ci);
		
		if (temp1) temp1 = temp1->suivant;
		if (temp2) temp2 = temp2->suivant;
	}
	if (precedent > 0){
		ajouteNum(res,precedent);
	}
	
	return res;
}
