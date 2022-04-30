package trees.Theory;

public class Intro 
{

	/*

		** TREE : Collection of nodes joined by edges coming from parent node
				
		
		** ROOT : A very first node on the top is ROOT.
		
		** PARENT AND CHILD : A node is parent to its very next descendent
		               A parent can have several child. 
		               A child can have only one parent
		               
		** SIBLING : Children with same parent
		
		** DESCENDENTS : Children , children of children and so on are descendents for a node
		
	    ** ANCESTORS : Parent , parent of parent and so on are ancestors for a node
		 
	    ** DEGREE OF NODE : Number of direct children for a node
		 
	    ** INTERNAL AND EXTERNAL NODES :
		        Node with degree = 0 are leaf nodes / external nodes
		        Node with degree > 0 are internal nodes / non-leaf nodes
		        
	    ** LEVEL : Root is 1st level. Children of ROOT are level 2 . Then children of level 2 nodes are level 3 nodes
		         and so on...
		         
	    ** HEIGHT : measured from ROOT . HEIGHT = level - 1
	    
	    ** FOREST : Collection of trees is a forest
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------



		 
		 
	*** BINARY TREE : 
		             A Tree where degree of each node is 2 or less
		             
		    --------------------------------------------------------------------------------------         
		             EX :
		             
		                O                                         O
		              /   \                                      / \
		             /     \                                    /   \
		            /       \                                  /     \
		           O         O                                O       O
                  / \       / \                               |      / \
                 /   \     /   \                              |     /   \
                O     O   O     O                             O    O     O

--------------------------------------------------------------------------------------------------------------------------
 
 
     ** CATALAN NUMBER :
            number of trees possible for given number of nodes
             --------------------        
            | T(n) =  2nCn/(n+1) |
             --------------------          
             ----------------------------------------
            | T(n) = SUM{T(i-1)*T(n-i)} : i = 1 to n |
             ----------------------------------------
             
        
        If we have labelled nodes :
              ---------------------------
            | T(n) =  fact(n)* 2nCn/(n+1)|
             ----------------------------
             
             
                                            --------
         Number of trees with max height = | 2^(n-1) |
                                            --------

---------------------------------------------------------------------------------------------------------------------------

    * Height vs no of nodes :
               
            if height = h
                     -----------------------------------
                    | 1) min no. of nodes = h+1         |
                    | 2) max no. of nodes = 2^(h+1) - 1 |
                     -----------------------------------
            if no. of nodes = n
                    -------------------------------------------------
                   | 1) max height of tree = n-1                     | 
                   | 2) min height of tree = ceil(log(n+1)/log2) - 1 |
                     ------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
       ------------------------------------
    * | No. of leaf nodes = N(deg = 2) + 1 |
       ------------------------------------                 
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------


     ** STRICT BINARY TREE :
                         Each node has degree = 2 or 0 
                         

               * Height vs nodes :
                                 
                            if height = h
                                   1) min no. of nodes = 2*h + 1
                                   2 ) max no. of nodes = 2^(h+1) - 1
                                   
                            if no. of nodes = n
                                   1) min height = log(n+1)/log2 - 1
                                   2) max height = (n-1)/2       
                                   
                                   
               * leaf nodes vs non-leaf nodes :
                                        
                                           no. of leaf nodes = no. of non-leaf nodes + 1
                                           
------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
                                           
          * STRICT m-ary TREE :
                  
                       if height = h
                          1) max no. of nodes = [m^(h+1) - 1]/(m-1)
                          2) min no of nodes = m*h + 1
                          
                       if no. of nodes = n
                           1) min height of tree = log[n(m-1)+1]/logm -1
                           2 ) max height of tree = (n-1)/m   


                      no. of leaf nodes = (2 * no. of internal nodes) + 1
                      
------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------

              
             *** FULL BT : 
                      A tree with height h and max nodes possible (2^(h+1)-1)  is full BT 
             

            *** COMPLETE BT :
                     A BT when represented using array , there should not be any blank in between.
                     There can be a blank at last.
                     
                     FULL BT is always a complete BT but vice versa need not be true.




	 */
	
	
	
	
}
