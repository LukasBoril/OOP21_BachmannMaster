#
# create branches for all users

createbranch () {
  git checkout -b $1
  echo ''
  echo "## Branch of $1." >> README.md
  git commit -am "initial of branch"
  git push origin $1
  git checkout develop
}

createbranch haller_stefan



