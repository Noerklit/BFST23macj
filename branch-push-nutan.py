from githubatitu import *
from subprocess import getoutput
from random import shuffle
from itertools import cycle
from collections import defaultdict

with open('/Users/nuli/BFST2023/studs.txt') as f:
    lines = f.readlines()

#print(getoutput('git remote add all https://github.itu.dk/SWU-FYP-Spring2023/BFST23nuli.git'))
for num,line in enumerate(lines):
    user = line.strip()    
    repo = 'BFST23'+user
    print(repo)   
    print(getoutput('git remote set-url --add --push all https://github.itu.dk/SWU-FYP-Spring2023/{}.git'.format(repo)))       
    #print(getoutput('git remote -v'))
    #print(getoutput('git add .'))
    #print(getoutput('git checkout -b branchX'))
    #print(getoutput('git push fun.txt branchX'))
    # THIS part of the code clones a remote repo, adds stuff to it, then commits the changes, checks out a new branch, 
    #and pushes the changes on a new branch. 
    #print(getoutput('git clone https://github.itu.dk/SWU-FYP-Spring2023/{}.git'.format(repo)))
    #print(getoutput('cp -r /Users/nuli/GitHubITU/startproject /Users/nuli/BFST2023/{}/.'.format(repo)))
    #print(getoutput('git -C /Users/nuli/BFST2023/{} add .'.format(repo)))
    #print(getoutput('git -C /Users/nuli/BFST2023/{} commit -m "added a start project"'.format(repo)))
    #print(getoutput('git -C /Users/nuli/BFST2023/{} checkout -b StartProject'.format(repo)))
    #print(getoutput('git -C /Users/nuli/BFST2023/{} push -u origin StartProject'.format(repo)))
    

    #getoutput('cd /Users/nuli/java-examples/Drawingdemo2/{}/'.format(repo))
    ######### Creates repos #########
    #createRepo(repo)
    #########

    ######### Deletes repos #########
    #deleteRepo(repo)
    #########

    ######### Removes collaborators #########
    # for t in tas:
    #     removeCollaborator(repo,t)

    #print(repo)
    ######### Adds student and TAs as collaborators #########
    #addCollaborator(repo,user)
    #addCollaborator(repo,'adbe')
    #addCollaborator(repo,'ehou')
    #addCollaborator(repo,'jouj')
    #addCollaborator(repo,'nako')
    #addCollaborator(repo,'frot')
    
    ######### Create a new branch in all repos.
    #getoutput('git clone https://github.itu.dk/SWU-FYP-Spring2023/{}.git'.format(repo))


    # getoutput('git remote add {} https://github.itu.dk/trbj/{}.git'.format(user,repo))
    # getoutput('git push {} handin1'.format(user))

# with open('README.md','w') as pretty, open('grade.txt','w') as grade:
#     for ta, studs in sorted(ta2studs.items()):
#         pretty.write(f'# {ta}:\n')
#         for stud in sorted(studs):
#             pretty.write(f'* <https://github.itu.dk/trbj/BFST22{stud}/releases>\n')
#             grade.write(f'{stud}\n')
