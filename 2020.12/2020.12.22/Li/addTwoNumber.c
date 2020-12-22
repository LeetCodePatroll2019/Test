#include <stdlib.h>
// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};
 

struct ListNode* carry(struct ListNode* l){
    if(l != NULL){
        if(l->val >= 10){
            l->val = l->val%10;
            if(l->next == NULL){
                l->next = malloc(sizeof(struct ListNode));
                l->next->val = 1;
                l->next->next = NULL;
            }else{
                (l->next)->val += 1;
                l->next = carry(l->next);
            }
        }else{
            l->next = carry(l->next);
        }
    }
    return l;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    if(l1 == NULL){
        return l2;
    }else if(l2 == NULL){
        return l1;
    }
    struct ListNode* cur = malloc(sizeof(struct ListNode));
    int entrer = 0;
    int val = l1->val + l2->val;
    cur->val = val;
    cur->next = addTwoNumbers(l1->next, l2->next);
    cur = carry(cur);
    return cur;
}