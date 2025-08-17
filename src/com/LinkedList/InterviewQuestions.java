package com.LinkedList;

import java.util.*;

public class InterviewQuestions {
    //cycle
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    //find length of cycle
    public static int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }
        return 0;
    }

    // finding the first node in cycle
    public static ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }
        if (length == 0) return null;
        //now find the start node
        ListNode s = head;
        ListNode f = head;
        while (length > 0) {
            s = s.next;
            length--;
        }

        //now we keep moving and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    //happy number
    //https://leetcode.com/problems/happy-number
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findNext(slow);
            fast = findNext(findNext(fast));  // two steps
        } while (slow != fast);
        return slow == 1;
    }

    private static int findNext(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }

    //middle of linked list
    //https://leetcode.com/problems/middle-of-the-linked-list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // in-place reversal of linked list
    //google/microsoft/amazon  : https://leetcode.com/problems/reverse-linked-list
    public ListNode reverse(ListNode head) {
//          if (size < 2) return;
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {  // null pointer check
                next = next.next;
            }
        }
        return prev;
    }

    //https://leetcode.com/problems/insertion-sort-list
    public ListNode insertionSortList(ListNode head) {
        int n = findLength(head);
        int[] arr = new int[n];
        ListNode temp = head;
        for (int i = 0; i < n && temp != null; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        Arrays.sort(arr);
        ;
        temp = head;
        for (int i = 0; i < n && temp != null; i++) {
            temp.val = arr[i];
            temp = temp.next;
        }

        return head;

    }


    //reverse between two points
    //https://leetcode.com/problems/reverse-linked-list-ii
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        //skip the first left-1 node;
        ListNode pres = head;
        ListNode prev = null;
        for (int i = 0; pres != null && i < left - 1; i++) {
            prev = pres;
            pres = pres.next;
        }
        //by the time prev =last -1  \\ pres=new node which become end of new reverse
        ListNode last = prev;
        ListNode newEnd = pres;

        // reverse between left and right
        ListNode next = pres.next;
        for (int i = 0; pres != null && i < right - left + 1; i++) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {  // null pointer check
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = pres;
        return head;
    }

    //check the linked list palindrome or not
    //https://leetcode.com/problems/palindrome-linked-list
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);
        ListNode rereverseHead = headSecond; //storing so after completion we re reverse it

        //now compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) break;  // not return because we to re reverse it
            head = head.next;
            headSecond = headSecond.next;
        }
        reverse(rereverseHead);
        return (head == null || headSecond == null);
    }

    //reorder list
    //https://leetcode.com/problems/reorder-list
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middleNode(head);
        ListNode hs = reverse(mid);
        ListNode hf = head;

        //rearrange it
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        //setting next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    /*
    reverse every k node
    https://leetcode.com/problems/reverse-nodes-in-k-group
    it also reversing <k items which not to be happen so modified it...
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1 || head == null) return head;

            //skip the first left-1 node;
            ListNode pres = head;
            ListNode prev = null;

            while (true) {
                ListNode last = prev;
                ListNode newEnd = pres;

                // reverse between left and right
                ListNode next = pres.next;
                for (int i = 0; pres != null && i < k; i++) {
                    pres.next = prev;
                    prev = pres;
                    pres = next;
                    if (next != null) {  // null pointer check
                        next = next.next;
                    }
                }
                if (last != null) {
                    last.next = prev;
                } else {
                    head = prev;
                }
                newEnd.next = pres;
                if (pres == null) break;

                prev = newEnd;

            }
            return head;
        }
    */

    //rotate list
    //https://leetcode.com/problems/rotate-list
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) return head;
        int length = findLength(head);
        k = k % length;   //no. of rotation
        while (k > 0) {
            ListNode prev = null;
            ListNode pres = head;
            while (pres.next != null) {
                prev = pres;
                pres = pres.next;
            }
            prev.next = null;
            pres.next = head;
            head = pres;
            k--;
        }
        return head;
    }

    private int findLength(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    //https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int length = findLength(temp);
        int ans = 0;
        while (temp != null) {
            ans += temp.val * Math.pow(2, length - 1);
            length--;
            temp = temp.next;
        }
        return ans;
    }

    //https://leetcode.com/problems/delete-node-in-a-linked-list
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //https://leetcode.com/problems/intersection-of-two-linked-lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

    //https://leetcode.com/problems/remove-linked-list-elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode temp = fake;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return fake.next;
    }

    /*
    https://leetcode.com/problems/merge-k-sorted-lists
        public ListNode mergeKLists(ListNode[] lists) {
            ArrayList<Integer> ans = new ArrayList<>();

            for(int i=0;i< lists.length;i++){
                while(lists[i]!=null){
                   ans.add( lists[i].val);
                    lists[i]=lists[i].next;
                }
            }
            Collections.sort(ans);
            ListNode dummy=new ListNode(-1);
            ListNode tail=dummy;
            int i=0;
            while(i<ans.size()){
                ListNode temp=new ListNode(ans.get(i));
                tail.next=temp;
                tail=tail.next;
                i++;
            }
            return dummy.next;
        }
    */

    //
    public int[] nextLargerNodes(ListNode head) {
        int n = findLength(head);
        ListNode curr = head;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = curr.val;
            curr = curr.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans=new int[n];
        for (int i = n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()) ans[i]=0;
            else ans[i]=stack.peek();
            stack.push(arr[i]);
        }
return ans;

    }

    //https://leetcode.com/problems/merge-k-sorted-lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return sortList(lists, 0, lists.length - 1);
    }

    public ListNode sortList(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = sortList(lists, start, mid);
        ListNode right = sortList(lists, mid + 1, end);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null) return null;
        Map<Integer,ListNode> map= new HashMap<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int prefixSum=0;
        ListNode curr=dummy;
        while(curr!=null){
            prefixSum+=curr.val;
            if(map.containsKey(prefixSum)){
                ListNode prev=map.get(prefixSum);
                ListNode toRemove=prev.next;
                int p=prefixSum + (toRemove!=null ? toRemove.val : 0);
                while(p!=prefixSum){
                    map.remove(p);
                    toRemove=toRemove.next;
                    p+=(toRemove!=null ? toRemove.val : 0);
                }
                prev.next=curr.next;
            }else {
                map.put(prefixSum,curr);
            }
            curr=curr.next;
        }
        return dummy.next;
    }

//https://leetcode.com/problems/odd-even-linked-list
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
   ListNode odd=head;
   ListNode even=head.next;
   ListNode temp=even;
   while(even!=null && even.next!=null){
       odd.next=even.next;
       odd=odd.next;
       even.next=odd.next;
       even=even.next;
   }
   odd.next=temp;
   return head;
    }
//https://leetcode.com/problems/reverse-nodes-in-even-length-groups
            public ListNode reverseEvenLengthGroups(ListNode head) {
                int left=1;
                int right=1;
                int length=findLength(head);
                while(left<=right  && right <=length){
                    int boxLength=right-left+1;
                    if(boxLength%2==0){
                        head=reverseBetween(head,left,right);
                    }
                    left=right+1;
                    right=left+boxLength;
                    if(right>length) right=length;
                }
                return head;
            }

//hard
    //https://leetcode.com/problems/reverse-nodes-in-k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        int right=k;
        int length=findLength(head);
        ListNode pres=head;
        ListNode prev=null;
        while( right<=length){
            ListNode last = prev;
            ListNode newEnd = pres;

            // reverse between left and right
            ListNode next = pres.next;
            for (int i = 0; pres != null && i < k; i++) {
                pres.next = prev;
                prev = pres;
                pres = next;
                if (next != null) {  // null pointer check
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = pres;
            prev=newEnd;
            right+=k;
        }
        return head;
    }



    // https://leetcode.com/problems/split-linked-list-in-parts/
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans = new ListNode[k];
        int length = findLength(head);
        int size = length / k;
        int extra = length % k;

        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
           ListNode newPart= new ListNode(0);
            ListNode tail = newPart;
            int partSize = size + (extra > 0 ? 1 : 0); // distribute extra nodes
            extra--; // decrement extra for next part if used

            for (int j = 0; j < partSize && curr != null; j++) {
                tail.next = new ListNode(curr.val);
                tail = tail.next;
                curr = curr.next;
            }
            ans[i] = newPart.next; // skip the dummy node
        }
        return ans;
    }



    //  https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return new int[]{-1,-1};
        ListNode prev = head;
        ListNode curr = head.next;
        int pos=0;
        List<Integer> checkPoints = new ArrayList<>();
        while( curr!=null && curr.next!=null){
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {
                checkPoints.add(pos);
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if(checkPoints.size()<2) return new int[]{-1,-1};
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < checkPoints.size(); i++) {
            minDistance = Math.min(minDistance, checkPoints.get(i) - checkPoints.get(i - 1));
        }
        int maxDistance = checkPoints.get(checkPoints.size() - 1) - checkPoints.get(0);
        return new int[]{minDistance, maxDistance};
    }




}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
