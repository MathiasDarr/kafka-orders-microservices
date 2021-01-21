

kops create cluster \
    --node-count=2 \
    --node-size=m3.large \
    --zones=us-west-2a \
    --name=kops_cluster