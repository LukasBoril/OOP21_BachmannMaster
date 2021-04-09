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


createbranch bajrami_kaltrim
createbranch berchtold_thomas
createbranch boban_pascal
createbranch boril_lukas
createbranch dilber_danijel
createbranch duss_nadine
createbranch gasser_matthias
createbranch giger_thomas
createbranch isler_oliver
createbranch nguyen_phat
createbranch popov_marjan
createbranch schmidt_patrick
createbranch stadelmann_daniel
createbranch widmer_sidney






