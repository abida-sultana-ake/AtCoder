a=int(raw_input())
b=int(raw_input())
c=int(raw_input())
mod=10**9+7
print (b-a)*c*pow(a**2-(b-a)*(c-a),mod-2,mod)%mod,(c-a)*b*pow(a**2-(c-a)*(b-a),mod-2,mod)%mod
