# Diogenic-Codex
Triglyphic encryption (ASCII characters) used as  form of encryption using Trees, ArrayLists and generics. 

Two programs are written:
1. A command-line tool that reads in text, creates a Diogenic codex/codebook, and creates an 'encrypted'
text file (consisting of the codebook, followed by binary patterns).
2. A command-line tool that accepts an encrypted text file, and extracts the codebook to restore the original
text (saving it into another file).
Additionally, I have also included the output and the diagram showing a Diogenic codex and it's codebook. 
The Diogenic codex itself is just a tree that we traverse to see which sequence of alternate symbols to build up. 'O' would mean left and '1' would mean right, when traversing the tree. We treat binary as a pattern of 0's and 1's and not as real numbers. 

